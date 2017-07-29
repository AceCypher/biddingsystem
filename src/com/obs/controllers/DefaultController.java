package com.obs.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obs.pojos.Bid;
import com.obs.pojos.Product;
import com.obs.service.IBidService;
import com.obs.service.IProductService;



@Controller
//@RequestMapping("/")
public class DefaultController {
	
	@Autowired
	private IBidService service;
	
	@Autowired
	private IProductService pservice;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	
	@RequestMapping("*")
	public String hello(HttpServletRequest request, Model map) {
	    System.out.println(request.getServletPath());
	    Map<String,Product> lp = new HashMap<>();
		Map<String,String> lp_time = new HashMap<>();
		for (Bid voz : service.getAllBids()) {
			lp.put(voz.getProductId().toString(), pservice.getProduct(Integer.valueOf(voz.getProductId().intValue())));
			
			long diffMs = voz.getTimerEnd().getTime() - voz.getTimerStart().getTime();
			long diffSec = diffMs / 1000;
			long min = diffSec / 60;
			long sec = diffSec % 60;
			String diff = "";
            long timeDiff = Math.abs(voz.getTimerEnd().getTime() - voz.getTimerStart().getTime());
            diff = String.format("%d-%d-", TimeUnit.MILLISECONDS.toHours(timeDiff),
                    TimeUnit.MILLISECONDS.toMinutes(timeDiff) - 
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
					
			lp_time.put(voz.getProductId().toString(), diff+""+sec);
			
		}
		map.addAttribute("prod_time", lp_time);
		map.addAttribute("prod_list", lp);
		map.addAttribute("bid_list", service.getAllBids());
		System.out.println("All the bids are here."+service.getAllBids());
		System.out.println("All the products are here."+lp);
		System.out.println("All the products times are here."+lp_time);
		
		System.out.println("in show reg form");
		return "/home/home_logout";
	}
}
