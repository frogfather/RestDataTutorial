package com.mistymorning.housekeeper.services.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.PasswordResetToken;
import com.mistymorning.housekeeper.classes.User;
import com.mistymorning.housekeeper.classes.UserDto;
import com.mistymorning.housekeeper.classes.VerificationToken;
import com.mistymorning.housekeeper.exceptions.UserAlreadyExistException;
import com.mistymorning.housekeeper.repository.PasswordResetTokenRepository;
import com.mistymorning.housekeeper.repository.RoleRepository;
import com.mistymorning.housekeeper.repository.UserRepository;
import com.mistymorning.housekeeper.repository.VerificationTokenRepository;
import com.mistymorning.housekeeper.services.api.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";
    public static String APP_NAME = "SpringRegistration";

    // API

    @Override
    public User registerNewUserAccount(final UserDto accountDto) {
        if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        LOGGER.debug("Registering new user {}",accountDto.getEmail());
        final User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public User getUser(final String verificationToken) {
        final VerificationToken token = tokenRepository.findByToken(verificationToken);
        if (token != null) {
        	LOGGER.debug("Verification token found for {}", token.getUser().getEmail());
            return token.getUser();
        }
        return null;
    }

    @Override
    public VerificationToken getVerificationToken(final String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(final User user) {
    	LOGGER.debug("Saving registered user {}", user.getEmail());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(final User user) {
        final VerificationToken verificationToken = tokenRepository.findByUser(user);

        if (verificationToken != null) {
        	LOGGER.debug("Deleting verification token for user "+user.getEmail());
            tokenRepository.delete(verificationToken);
        }

        final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(user);

        if (passwordToken != null) {
        	LOGGER.debug("Deleting password reset token for user "+user.getEmail());
            passwordTokenRepository.delete(passwordToken);
        }
        
        userRepository.delete(user);
    }

    @Override
    public void createVerificationTokenForUser(final User user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        LOGGER.debug("Creating new verification token for user "+user.getEmail());
        tokenRepository.save(myToken);
    }

    @Override
    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID()
            .toString());
        vToken = tokenRepository.save(vToken);
        LOGGER.debug("Updating expired verification token for user "+vToken.getUser().getEmail());
        return vToken;
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        LOGGER.debug("Creating new password reset token for user "+user.getEmail());
        passwordTokenRepository.save(myToken);
    }

    @Override
    public User findUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token);
    }

    @Override
    public User getUserByPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token)
            .getUser();
    }

    @Override
    public Optional<User> getUserByID(final long id) {
        return userRepository.findById(id);
    }

    @Override
    public void changeUserPassword(final User user, final String password) {
        user.setPassword(passwordEncoder.encode(password));
        LOGGER.debug("Updating password for user "+user.getEmail());
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public String validateVerificationToken(String token) {
    	LOGGER.debug("Validating verification token");
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
        	LOGGER.debug("Verification token is not valid");
            return TOKEN_INVALID;
        }
        
        final User user = verificationToken.getUser();
        LOGGER.debug("Verification token for user {} found, checking validity",user.getEmail());
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate()
            .getTime()
            - cal.getTime()
                .getTime()) <= 0) {
            tokenRepository.delete(verificationToken);
            LOGGER.debug("Verification token for user {} expired",user.getEmail());
            return TOKEN_EXPIRED;
        }

        user.setEnabled(true);
        // tokenRepository.delete(verificationToken);
        userRepository.save(user);
        return TOKEN_VALID;
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

}