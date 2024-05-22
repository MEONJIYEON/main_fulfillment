package com.ot.main.admin.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

	//showLogin
	ModelAndView showLogin();
	
	//Login
	ModelAndView login(@RequestParam String id);
	
	//Home
	ModelAndView showHome();
}
