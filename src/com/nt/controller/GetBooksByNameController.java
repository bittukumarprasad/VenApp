package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
public class GetBooksByNameController {
	@Autowired
	private IBookService service;

	@RequestMapping(value = "/getBooksByName", method = RequestMethod.POST)
	public String getBooksByName(@ModelAttribute("book") Book b, ModelMap map, HttpServletRequest req)
			throws JsonParseException, JsonMappingException, IOException {
		HttpSession ses = req.getSession(false);
		String cookie = (String) ses.getAttribute("cook");
		map.addAttribute("cookie", cookie);
		// use service class
		List<Book> listBook = service.getBooksByName(b.getName().toString());
		map.addAttribute("data", listBook);
		return "getBookByNameResultPage";
	}
}
