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

    @Autowired
    ActiveUserStore activeUserStore;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        LOG.debug("CustomLoginAuthenticationSuccessHandler: onAuthenticationSuccess method called");
    	addWelcomeCookie(getUserName(authentication), response);
        redirectStrategy.sendRedirect(request, response, "/homepage.html?user=" + authentication.getName());

        final HttpSession session = request.getSession(false);
        if (session != null) {
            session.setMaxInactiveInterval(30 * 60);
            String username;
            if (authentication.getPrincipal() instanceof User) {
            	username = ((User)authentication.getPrincipal()).getEmail();
            }
            else {
            	username = authentication.getName();
            }
       
            LoggedUser user = new LoggedUser(username, activeUserStore);
            session.setAttribute("user", user);
        }
        clearAuthenticationAttributes(request);
    }

    private String getUserName(final Authentication authentication) {
    	LOG.debug("CustomLoginAuthenticationSuccessHandler - getUserName called");
        return ((User) authentication.getPrincipal()).getFirstName();
    }

    private void addWelcomeCookie(final String user, final HttpServletResponse response) {
    	LOG.debug("CustomLoginAuthenticationSuccessHandler - addWelcomeCookie called");
        Cookie welcomeCookie = getWelcomeCookie(user);
        response.addCookie(welcomeCookie);
    }

    private Cookie getWelcomeCookie(final String user) {
    	LOG.debug("CustomLoginAuthenticationSuccessHandler getWelcomeCookie called");
        Cookie welcomeCookie = new Cookie("welcome", user);
        welcomeCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
        return welcomeCookie;
    }

    protected void clearAuthenticationAttributes(final HttpServletRequest request) {
    	LOG.debug("CustomLoginAuthenticationSuccessHandler clear authentication attributes");
        final HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
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