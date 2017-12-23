package com.nt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.IBookService;
import com.nt.util.JsonUtil;
import com.nt.util.Login;

@RestController
public class LoginController {
	@Autowired
	private IBookService service;

	@RequestMapping(value = "/loginCheck.htm", method = RequestMethod.POST)
	public String checkIdentity(@ModelAttribute("login") Login log, ModelMap map, HttpServletRequest req,
			 HttpSession ses) throws JsonParseException, JsonMappingException, IOException {
		String responseMessage = "";
		String username = log.getUsername();
		String password = log.getPassword();

		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		// convert to json data
		String jsonLogin = JsonUtil.convertJavaToJson(login);
		// use service class
		String jsonMessage = service.checkIdentity(jsonLogin);
		// convert to java Obj
		String providerMessage = JsonUtil.convertJsonToJava(jsonMessage, String.class);

		System.out.println();
		if (providerMessage.equalsIgnoreCase("Valid User")) {
			responseMessage = "Welcome to Login Page Mr/Mrs " + username;
			map.addAttribute("message", responseMessage);
			ses = req.getSession(true);
			username="Logged By Mr/Mrs:"+username;
			ses.setAttribute("cook", username);
			return "home";
		} else {
			responseMessage = "Invalid Credential has been Found!";
			map.addAttribute("message", responseMessage);
			return "login";
		}

	}
}
