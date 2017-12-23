package com.nt.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.IBookService;
import com.nt.util.Book;

@Controller
public class DeleteController {
	@Autowired
	private IBookService service;

	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@RequestParam("isbn") Integer isbn, ModelMap map)
			throws JsonParseException, JsonMappingException, IOException {
		
		// use serice class
		List<Book> listBook = service.deleteAndGivesUpdatedResult(isbn);
	
		map.addAttribute("data", listBook);
		return "result";

	}

	{

	}

}
