package com.obs.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/cust")
public class CustomerLogoutController {
	@GetMapping(value = "/logout")
	public String logout(HttpSession hs,Model map) {
		System.out.println("in logout");
		map.addAttribute("status123", hs.getAttribute("status"));
		hs.invalidate();
		return "/cust/logout";
	}
}
