package com.mistymorning.housekeeper.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component("customLogoutSuccessHandler")
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LOG.debug("CustomLogoutSuccessHandler - onLogoutSuccess");
    	final HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
        }

        response.sendRedirect("/logout.html?logSucc=true");
    }
}