package com.mistymorning.housekeeper.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.mistymorning.housekeeper.security.google2fa.CustomAuthenticationProvider;
import com.mistymorning.housekeeper.security.google2fa.CustomWebAuthenticationDetailsSource;

@Configuration
@ComponentScan(basePackages = { "com.mistymorning.housekeeper.security" })
// @ImportResource({ "classpath:webSecurityConfig.xml" })
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private CustomWebAuthenticationDetailsSource authenticationDetailsSource;

    public SecSecurityConfig() {
        super();
    }

    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
    	// eventually our session management should be:
    	// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*",
                        "/user/resendRegistrationToken*" ,"/forgetPassword*", "/user/resetPassword*",
                        "/user/changePassword*", "/emailError*", "/resources/**").permitAll()
                .antMatchers("/user/updatePassword*","/user/savePassword*","/updatePassword*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
                .anyRequest().hasAuthority("READ_PRIVILEGE")
                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .failureHandler(authenticationFailureHandler)
                .authenticationDetailsSource(authenticationDetailsSource)
            .permitAll()
                .and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .logout()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .logoutSuccessUrl("/logout.html?logSucc=true")
                .permitAll();
    // @formatter:on
    }

    // beans

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
}