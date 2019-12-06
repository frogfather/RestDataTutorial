package com.mistymorning.housekeeper.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.User;
import com.mistymorning.housekeeper.security.AuthenticationRequest;
import com.mistymorning.housekeeper.security.AuthenticationResponse;
import com.mistymorning.housekeeper.services.api.UserService;
import com.mistymorning.housekeeper.utilities.JwtUtil;


@RestController
@RequestMapping("/users")
public class UserController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST) 
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
			
		} catch (BadCredentialsException e) {
			LOG.debug("Authentication failed for user "+authenticationRequest.getUsername());
			throw new Exception("Incorrect username or password, e");
		}
		
		final User user = userService
				.findUserByEmail(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(user);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
				
		
	}

}
