package com.nt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {
	@RequestMapping(value = "/logout.htm")
	public String logOut(ModelMap map, HttpServletRequest req) {
		String cookie = "";
		HttpSession ses = req.getSession(false);
		cookie = (String) ses.getAttribute("cook");

		map.addAttribute("cookie", cookie);
		String message = "Logged Out Successfully:" + cookie.subSequence(10, 22);
		map.addAttribute("message", message);
		return "login";
	}

}
