package com.mistymorning.housekeeper.services.api;

public interface UserSecurityService {
	String validatePasswordResetToken(long id, String token);
}
