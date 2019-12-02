package com.mistymorning.housekeeper.security;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mistymorning.housekeeper.classes.User;

//@Component("customAuthenticationSuccessHandler")
public class CustomLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
    	//this will disappear
    }

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
    	LOG.debug("CustomLoginAuthenticationSuccessHandler set redirect strategy");
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
    	LOG.debug("CustomLoginAuthenticationSuccessHandler get redirect strategy");
        return redirectStrategy;
    }
}