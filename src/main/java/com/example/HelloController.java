package com.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
		
	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String loginpage(Locale locale, Model model ) {
		return "login";
		
	}
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String login(@Validated User user, Model model) {
		model.addAttribute("userName", user.getUsername());
		return "user";
	}
} 
