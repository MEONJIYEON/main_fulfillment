package com.ot.main.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminController {

	//showLogin
	public String showLogin();
	
	//Login
	public String login(@RequestParam String id,  Model model);
	
}
