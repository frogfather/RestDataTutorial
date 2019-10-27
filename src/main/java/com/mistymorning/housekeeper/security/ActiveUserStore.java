package com.mistymorning.housekeeper.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActiveUserStore {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

    public List<String> users;

    public ActiveUserStore() {
    	LOG.debug("Create active users store");
        users = new ArrayList<String>();
    }

    public List<String> getUsers() {
    	LOG.debug("Active users store: get users");
        return users;
    }

    public void setUsers(List<String> users) {
    	LOG.debug("Active users store: set users");
        this.users = users;
    }
}
