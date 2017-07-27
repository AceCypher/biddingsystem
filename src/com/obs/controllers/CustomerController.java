package com.obs.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.obs.pojos.Customer;
import com.obs.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	//@Qualifier("cust_service")
	private CustomerService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@GetMapping(value = "/register")
	public String showRegForm(Customer c) {
		System.out.println("in show reg form");
		return "/cust/register";
	}

	// req handling method to process form
	@PostMapping(value = "/register")
	public String processRegForm(RedirectAttributes attrs, @Valid Customer c1, BindingResult res) {
		System.out.println("in process reg form " + c1);
		if (res.hasErrors()) {
			System.out.println("p.l errs : processing reg form " + res);
			return "/cust/register";
		}
		attrs.addFlashAttribute("status", service.registerCustomer(c1));
		return "redirect:/cust/login";
	}

	// list customers
	@GetMapping("/list")
	public String listCustomers(Model map) {
		System.out.println("in list custs " + map.getClass().getName());
		map.addAttribute("cust_list", service.listCustomers());
		return "/cust/list";
	}

	@GetMapping(value = "/login")
	public String showLoginForm(Customer c, Model map) {
		System.out.println("in show login form " + map);
		return "/cust/login";
	}

	// process login form
	@PostMapping(value = "/login")
	public String processLoginForm(@Valid Customer c, BindingResult res,RedirectAttributes attrs, HttpSession hs) {
		if (res.hasFieldErrors("email") || res.hasFieldErrors("password")) {
			System.out.println("p l errs in process login");
			return "/cust/login";
		}
		
		System.out.println("in process login form " + c);
		if(c.getEmail().equals("admin") && c.getPassword().equals("admin")){
			return "redirect:/cust/admin";
		}
		String sts = service.validateCustomer(c.getEmail(), c.getPassword());
		
		if (sts.contains("Fail")) {
			attrs.addAttribute("status", sts);
			return "/cust/login";
		}
		hs.setAttribute("status", sts);
		return "redirect:/home";
	}

	
	
	// show update form
	@GetMapping(value = "/update")
	public String showUpdateForm(@RequestParam int id, Model map) {
		System.out.println("in show update form " + id);
		map.addAttribute("customer", service.getCustomerById(id));// detached
		return "/cust/update";
	}

	// req handling method to process update form
	@PostMapping(value = "/update")
	public String processUpdateForm(
			/* HttpServletRequest rq, @RequestParam int id, */ RedirectAttributes attrs, @Valid Customer c1,
			BindingResult res) {
		System.out.println("in proc update form " + " " + c1);
		if (res.hasErrors()) {
			System.out.println("p.l errs : processing reg form " + res);
			return "/cust/update";
		}
		// c1.setId(id);
		System.out.println("in process update form , no pl errs " + c1);
		attrs.addFlashAttribute("status", service.updateCustomer(c1));
		return "redirect:/cust/list";
	}

	// req handling method to delete customer details
	@GetMapping(value = "/delete/{custId}")
	public String processUpdateForm(@PathVariable int custId, RedirectAttributes attrs) {

		System.out.println("in delete customer  " + custId);
		attrs.addFlashAttribute("status", service.deleteCustomer(custId));
		return "redirect:/cust/list";
	}
	
	// req handling method to delete customer details
	@GetMapping(value = "/temp/{custId}")
	public String processTempForm(@PathVariable int custId, RedirectAttributes attrs) {
	
		System.out.println("in template customer  " + custId);
		//attrs.addFlashAttribute("status", service.deleteCustomer(custId));
		return "/cust/template";
	}

	
	@GetMapping("/{path}")
	public String globalMapper(@PathVariable String path) {
		System.out.println("in global " + path);
		return "/cust/"+path;
	}

}
