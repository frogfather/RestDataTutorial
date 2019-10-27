package com.mistymorning.housekeeper.listeners;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.mistymorning.housekeeper.security.LoginAttemptService;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent e) {
        // final WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
        // if (auth != null) {
        // loginAttemptService.loginSucceeded(auth.getRemoteAddress());
        // }
        final String xfHeader = request.getHeader("X-Forwarded-For");
        LOG.debug("Authentication success event detected");
        if (xfHeader == null) {
            loginAttemptService.loginSucceeded(request.getRemoteAddr());
        } else {
            loginAttemptService.loginSucceeded(xfHeader.split(",")[0]);
        }
    }

}