package com.nt.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nt.util.Book;
import com.nt.util.JsonUtil;

@Service
public class BookServiceImpl implements IBookService {
	private static final String GETALLBOOKS = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/getAllBooks";
	private static final String GETBOOKBYISBN = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/getBooksByIsbn/{isbn}";
	private static final String GETBOOKBYNAME = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/getBooksByName/{name}";
	private static final String loginCheck = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/login";
	private static final String deletebYIsbnAndGivesUpdatedResult = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/deleteBookByIsbn/{isbn}";
	private static final String UPDATE = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/updateBook";
	private static final String SAVEBOOK = "http://localhost:2525/Spring-Rest-HibernateTemplateServiceProvider/books/save";
	RestTemplate rt = new RestTemplate();

	@Override
	public List<Book> getAllBooks() throws JsonParseException, JsonMappingException, IOException {

		// use WEBSERVICES

		String listOfJsonBook = rt.getForObject(GETALLBOOKS, String.class);
		// convert json to java obj
		List<Book> listOfJavaBook = JsonUtil.convertJsonToJava(listOfJsonBook, List.class);
		return listOfJavaBook;
	}

	public Book getBookByIsbn(int isbn) throws JsonParseException, JsonMappingException, IOException {
		String bookJson = rt.getForObject(GETBOOKBYISBN, String.class, isbn);

		// convert to java obj
		Book book = JsonUtil.convertJsonToJava(bookJson, Book.class);
		return book;
	}

	@Override
	public List<Book> getBooksByName(String name) throws JsonParseException, JsonMappingException, IOException {
		// use WEBSERVICES
		String listOfJsonBook = rt.getForObject(GETBOOKBYNAME, String.class, name);
		// convert json to java obj
		List<Book> listOfJavaBook = JsonUtil.convertJsonToJava(listOfJsonBook, List.class);
		return listOfJavaBook;
	}

	@Override
	public String checkIdentity(String jsonLogin) {

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonLogin, header);
		String json = rt.postForObject(loginCheck, entity, String.class);

		return json;

	}

	@Override
	public List<Book> deleteAndGivesUpdatedResult(int isbn)
			throws JsonParseException, JsonMappingException, IOException {

		String json = rt.getForObject(deletebYIsbnAndGivesUpdatedResult, String.class, isbn);

		// convert to java obj
		List<Book> listBook = JsonUtil.convertJsonToJava(json, List.class);

		return listBook;
	}

	@Override
	public String update(String jsonBook) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBook, header);
		String listOfJsonBook = rt.postForObject(UPDATE, entity, String.class);

		return listOfJsonBook;
	}

	@Override
	public int save(Book book) throws JsonGenerationException, JsonMappingException, IOException {
		// convert book to json
		String jsonBook = JsonUtil.convertJavaToJson(book);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBook, headers);
  System.out.println("postForObject()");
		String id = rt.postForObject(SAVEBOOK, entity, String.class);
		System.out.println("exit pfo()"+id);
		// convert id to java obj
		Book book1 = JsonUtil.convertJsonToJava(id, Book.class);
		System.out.println(book1.getIsbn());
		int serid=book1.getIsbn();
		return serid;
	}

}