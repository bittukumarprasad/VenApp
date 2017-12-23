package com.nt.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.nt.util.Book;

public interface IBookService {

	public List<Book> getAllBooks() throws JsonParseException, JsonMappingException, IOException;

	public Book getBookByIsbn(int isbn) throws JsonParseException, JsonMappingException, IOException;

	public List<Book> getBooksByName(String name) throws JsonParseException, JsonMappingException, IOException;

	public String checkIdentity(String jsonLogin);
	
	public List<Book> deleteAndGivesUpdatedResult(int isbn) throws JsonParseException, JsonMappingException, IOException;
	
	public String update(String jsonBook);
	
	public int save(Book book) throws JsonGenerationException, JsonMappingException, IOException;

}
