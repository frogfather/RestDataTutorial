package com.mistymorning.housekeeper.security;

import java.sql.Date;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.mistymorning.housekeeper.exceptions.InvalidJwtAuthenticationException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";
    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h
    @Autowired
    private UserDetailsService userDetailsService;
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    public String createToken(String username, List<String> roles) {
    	LOG.debug("JWT Token provider: create token");
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);
        Date now = new Date(validityInMilliseconds);
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()//
            .setClaims(claims)//
            .setIssuedAt(now)//
            .setExpiration(validity)//
            .signWith(SignatureAlgorithm.HS256, secretKey)//
            .compact();
    }
    public Authentication getAuthentication(String token) {
    	LOG.debug("JWT Token provider - get authentication");
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    public String getUsername(String token) {
    	LOG.debug("JWT Token provider - get username");
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
    public String resolveToken(HttpServletRequest req) {
    	LOG.debug("JWT Token provider - resolve token");
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
    public boolean validateToken(String token) {
    	LOG.debug("JWT Token provider - validate token");
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            if (claims.getBody().getExpiration().before(new Date(validityInMilliseconds))) {
                return false;
            }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
        }
    }
}