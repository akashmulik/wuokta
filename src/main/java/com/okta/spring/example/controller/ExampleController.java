package com.okta.spring.example.controller;

import java.util.Collections;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * This example controller has endpoints for displaying the user profile info on
 * {code}/{code} and "you have been logged out page" on
 * {code}/post-logout{code}.
 */
@Controller
public class ExampleController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/profile")
	@PreAuthorize("hasAuthority('SCOPE_profile')")
	public ModelAndView userDetails(OAuth2AuthenticationToken authentication) 
	{
		return new ModelAndView("userProfile", Collections.singletonMap("details", authentication.getPrincipal().getAttributes()));
	}
}