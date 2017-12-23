package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowHomeController {

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String showHome(HttpServletRequest req) {
		System.out.println("entry of home");
		HttpSession ses=req.getSession(true);
		return "home";
	}
}
