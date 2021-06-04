package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.RoadService;

@Controller
public class MainController extends BaseController {

	@Autowired
	private RoadService roadService;
	
	@RequestMapping( value = "/" )
	public ModelAndView root() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping( value = "/road" )
	@ResponseBody
	public ModelAndView roadName() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("roadData", roadService.getRoadData() );
		mav.setViewName("index");
		return mav;
	}
	
}
