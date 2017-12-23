package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.IBookService;
import com.nt.util.Book;

@Controller
public class GetAllController {
	@Autowired
	private IBookService service;

	public GetAllController() {
		System.out.println("Controller");
	}

	@RequestMapping(value = "/getAllEmployee.htm", method = RequestMethod.GET)
	public String getAllBooks(ModelMap map, HttpServletRequest req, HttpServletResponse res)
			throws JsonParseException, JsonMappingException, IOException {
		// use service class
		HttpSession ses = req.getSession(false);
		String cookie = (String) ses.getAttribute("cook");

		map.addAttribute("cookie", cookie);
		List<Book> listOfBooks = service.getAllBooks();
		map.addAttribute("data", listOfBooks);
		return "result";
	}

}
