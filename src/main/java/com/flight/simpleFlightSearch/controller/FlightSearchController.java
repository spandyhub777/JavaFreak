package com.flight.simpleFlightSearch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.flight.simpleFlightSearch.model.FlightInfo;
import com.flight.simpleFlightSearch.service.FlightService;

//import jbr.springmvc.model.Login;
//import jbr.springmvc.model.User;
//import jbr.springmvc.service.UserService;
@Controller
@Component
public class FlightSearchController {
  @Autowired
  FlightService flightService;
//  @RequestMapping(value = "/search", method = RequestMethod.GET)
//  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
//    ModelAndView mav = new ModelAndView("login");
//    //mav.addObject("login", new Login());
//    return mav;
//  }
  String num ="";
  JSONObject status= null;
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcome(Model model)
	{
		model.addAttribute("greeting","Welcome to Flight Search Application");
		model.addAttribute("Welcome aboard!! ", num);
		model.addAttribute("info", "Please enter a valid Flight Number");
		return "welcome";
	}
 
	@RequestMapping(value = "/flight", method = RequestMethod.GET)
	 public String searchflight(Model model) {
		if (null != status)
		{
			String information = status.entrySet().toString();
			model.addAttribute("info", status.entrySet().toString());
		}
		else
		model.addAttribute("info", "Invalid Flight number");
		return "flight";
		  }
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	 public RedirectView search(@RequestParam(value="flightNum") String fNum, Model model) {
		num = fNum;
		status = flightService.flightDataFromJson(num);
		if (null != status)
		return new RedirectView("flight");
		else return new RedirectView("welcome");
		  }
	
}