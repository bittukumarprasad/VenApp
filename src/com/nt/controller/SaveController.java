package com.nt.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
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
public class SaveController {
	@Autowired
	private IBookService service;

	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute("book") Book book, ModelMap map)
			throws JsonGenerationException, JsonMappingException, IOException {
		// use service class
		System.out.println("entry to save");
		int id = service.save(book);
		System.out.println("id==" + id);
		String message = "";
		if (id >= 1) {
			message = "successfully inserted";

		} else {
			message = "Insertion failed please Try again!";
			map.addAttribute("message", message);
			return "result";
		}

		// get Updated result so calling getAllDetails
		List<Book> listOfBook = service.getAllBooks();
		map.addAttribute("message", message);
		map.addAttribute("data", listOfBook);
		return "result";

	}

	@RequestMapping(value = "/save.htm", method = RequestMethod.GET)
	public String showSaveForm() {

		return "save";

	}

}
