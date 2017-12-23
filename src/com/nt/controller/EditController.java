package com.nt.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.IBookService;
import com.nt.util.Book;
import com.nt.util.JsonUtil;

@RestController
public class EditController {
	@Autowired
	private IBookService service;

	@RequestMapping(value = "/edit.htm")
	public String edit(@RequestParam("isbn") int isbn, ModelMap map)
			throws JsonParseException, JsonMappingException, IOException {
		// use service class to get the details

		Book book = service.getBookByIsbn(isbn);
		System.out.println("sjcsjcjs" + book.getIsbn() + book.getName() + book.getPrice());
		map.addAttribute("editData", book);
		return "editForm";
	}

	@RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
	public String editPost(@ModelAttribute("book") Book book, ModelMap map)
			throws JsonParseException, JsonMappingException, IOException {
		// convert book to json data

		String jsonBook = JsonUtil.convertJavaToJson(book);

		// use service class to get the details
		String listOfJsonUpdatedBook = service.update(jsonBook);
		// convert to java obj
		List<Book> listOfBook = JsonUtil.convertJsonToJava(listOfJsonUpdatedBook, List.class);

		System.out.println("sjcsjcjs" + book.getIsbn() + book.getName() + book.getPrice());
		map.addAttribute("data", listOfBook);
		return "result";
	}
}
