package com.okta.spring.example.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The default Spring logout behavior redirects a user back to
 * {code}/login?logout{code}, so you will likely want to change that. The
 * easiest way to do this is by extending from
 * {@link WebSecurityConfigurerAdapter}.
 */
@Configuration
class WebConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// allow antonymous access to the root page
				.antMatchers("/").permitAll()
				// all other requests
				.anyRequest().authenticated()

				// set logout URL
				.and().logout().logoutSuccessUrl("/")

				// enable OAuth2/OIDC
				.and().oauth2Client().and().oauth2Login();
	}
}