package org.polytec.vermeg.test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.polytec.vermeg.controller.BookController;
import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

class BookControllerTest {
	@Mock 
	private BookService bookService ;
	
	@InjectMocks 
	private BookController bookController  ;

	@Autowired
	private MockMvc mockMvc ;
	
	@BeforeEach
	 public void Setup() {
		 MockitoAnnotations.initMocks(this);	
		
		 mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	 } 
	 


	@Test
	void testGetBooks() throws Exception {
		List<Book> books = new ArrayList<>() ;
	
		books.add(new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12")));
		books.add(new Book(2,"title2", "author2", 10, java.sql.Date.valueOf("2020-12-12")));
	when(bookService.getAllBooks()).thenReturn((List<Book>)books ) ;
	 mockMvc.perform(get("/api/book/get"))
     .andExpect(status().isOk())
     .andExpect(jsonPath("$", hasSize(2)))
     .andDo(print()) ;
}

	

	@Test
	void addBook() throws Exception {
	

			Book book=new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));  

		
		       mockMvc.perform(post("/api/book/addBook")
		                .contentType(MediaType.APPLICATION_JSON)
		                .content(new ObjectMapper().writeValueAsString(book)))
		            .andExpect(status().isOk())
		            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		            .andDo(print());
		    }
		
	
	
	@Test
	void updateBook() throws Exception {
	

			Book book=new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));  

		
		       mockMvc.perform(put("/api/book/updateBook/1")
		                .contentType(MediaType.APPLICATION_JSON)
		                .content(new ObjectMapper().writeValueAsString(book)))
		            .andExpect(status().isOk())
		            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		            .andDo(print());
		    }
		
	@Test
	void deleteBook() throws Exception {
		

		Book book=new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));  

		mockMvc.perform(delete("/api/book/deleteBook/1")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(book)))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andDo(print());
	    }
	
	@Test
	void testCalSommePrixTotal() throws Exception {
		Book book1= new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));
		Book book2= new Book(2,"title2", "author2", 10, java.sql.Date.valueOf("2020-12-12"));
		Book book3= new Book(3,"title3", "author3", 10, java.sql.Date.valueOf("2020-12-12"));
		List <Integer> liste = new ArrayList <Integer>();
		liste.add(book1.getId());
		liste.add(book2.getId());
		liste.add(book3.getId());
		  mockMvc.perform(post("/api/book/calSommePrixTotal")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(liste)))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andDo(print());
		
		assertEquals(bookController.calSommePrixTotal(liste),30.0);
		
	}
}
