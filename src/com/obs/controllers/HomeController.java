package com.obs.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.obs.pojos.*;
import com.obs.service.IBidService;
import com.obs.service.IProductService;


@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private IBidService service;
	
	@Autowired
	private IProductService pservice;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@GetMapping(value = "")
	public String showHomePage(Bid c, Model map) throws ParseException {
		Map<String,Product> lp = new HashMap<>();
		Map<String,String> lp_time = new HashMap<>();
		for (Bid voz : service.getAllBids()) {
			lp.put(voz.getProductId().toString(), pservice.getProduct(Integer.valueOf(voz.getProductId().intValue())));
			//int diffInSeconds = (int)( (voz.getTimerEnd().getTime() - voz.getTimerStart().getTime()) / (1000) );
			//long duration  = voz.getTimerEnd().getTime() - voz.getTimerStart().getTime();
			//long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
			//long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
			//long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
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
		return "/home/home_login";
	}
	
	@GetMapping(value = "/add_bid")
	public String showRegForm(Bid b) {
		System.out.println("in add bid form");
		return "/home/add_bid";
	}

	// req handling method to process form
	@PostMapping(value = "/add_bid")
	public String processAddBidForm(RedirectAttributes attrs, @Valid Bid b, BindingResult res) {
		System.out.println("in process reg form " + b);
		if (res.hasErrors()) {
			System.out.println("p.l errs : processing reg form " + res);
			return "/home/add_bid";
		}
		attrs.addFlashAttribute("status", service.addBid(b));
		return "redirect:/home/add_bid";
	}

	
	@PostMapping("/check")     
	@ResponseBody
	public String processBid(@RequestParam Integer bidId, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("in process bid form " + bidId);
		
		return service.bidThis(bidId);
	}
	@PostMapping("/updatePrice")     
	@ResponseBody
	public String updateBid(@RequestParam Integer bidId, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("in update bid form " + bidId);
		
		return service.getBidAmount(service.getBid(bidId)).toString();
	}
	@GetMapping("/{path}")
	public String globalMapper(@PathVariable String path) {
		System.out.println("in global " + path);
		return "/home/"+path;
	}
}
