package com.mistymorning.housekeeper.security;


import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

@Component
public class LoggedUser implements HttpSessionBindingListener {
  

    private String username;

    public LoggedUser(String username) {
        this.username = username;
    }

    public LoggedUser() {
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
    	
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
    	
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}