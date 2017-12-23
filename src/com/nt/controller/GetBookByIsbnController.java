package com.nt.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.IBookService;
import com.nt.util.Book;

@Controller
public class GetBookByIsbnController {
	@Autowired
	private IBookService service;

	@RequestMapping(value = "/getBookByIsbn.htm", method = RequestMethod.POST)
	public String getByIsbn(HttpServletRequest req, @ModelAttribute("book") Book b, ModelMap map)
			throws JsonParseException, JsonMappingException, IOException {
		HttpSession ses = req.getSession(false);
		String cookie = (String) ses.getAttribute("cook");
		map.addAttribute("cookie", cookie);
		// use service class
		Book book = service.getBookByIsbn(b.getIsbn());
		map.addAttribute("data", book);
		return "getBookByIsbnResultPage";
	}

}
