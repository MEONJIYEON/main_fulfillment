package com.ot.main.admin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.main.admin.controller.AdminController;
import com.ot.main.admin.data.dto.AdminResponseDTO;
import com.ot.main.admin.service.AdminService;

@RestController
@RequestMapping(value = "/api/v1/main-fulfillment")
public class AdminControllerImpl implements AdminController {
	

	private final AdminService adminService;
	
	@Autowired
	public AdminControllerImpl(AdminService adminService) {
		System.out.println("==========AdminControllerImpl============"); // delete!!!!!
		this.adminService = adminService;
	}
	
	@GetMapping("/showLogin")
	@Override
	public String showLogin() {
		 return "login";
	}

	@GetMapping("/login")
	@Override
	//login
	public String login(String id, Model model) {
		
		AdminResponseDTO loginResult = adminService.login(id);
		
		if (loginResult.getId() != null) {
			//login success
			System.out.println("loginResult : " + loginResult);
			model.addAttribute("loginResult", loginResult);
			
			return "next";
		}else {
			//login fail
			System.out.println("loginResult : " + loginResult);
			return "login";
		}
	
	}
	
	
}
