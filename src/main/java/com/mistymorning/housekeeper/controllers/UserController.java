package com.mistymorning.housekeeper.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mistymorning.housekeeper.services.api.UserService;

@Controller
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/loggedUsersFromSessionRegistry", method = RequestMethod.GET)
    public String getLoggedUsersFromSessionRegistry(final Locale locale, final Model model) {
    	LOG.debug("User controller - GET: logged users from session registry");
        model.addAttribute("users", userService.getUsersFromSessionRegistry());
        return "users";
    }
}