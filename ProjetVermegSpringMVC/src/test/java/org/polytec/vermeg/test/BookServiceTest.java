package org.polytec.vermeg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.polytec.vermeg.dao.BookDAO;
import org.polytec.vermeg.model.Book;

class BookServiceTest {
	BookDAO bookDao  = mock(BookDAO.class);

	@Test
	void testgetAllBooks() {
	 List<Book> books= new ArrayList<Book>();
	Book book1 = new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));
	Book book2 = new Book(2,"title2", "author2", 10, java.sql.Date.valueOf("2020-12-12"));
	 books.add(book1);
	 books.add(book2);
	 when(bookDao.getAllBooks()).thenReturn(books);
	 assertEquals(2,books.size());
	 assertEquals("title1",books.get(0).getTitle());
	 assertEquals("title2",books.get(1).getTitle());
	 assertEquals(bookDao.getAllBooks(),books);
	}
	@Test
	void testgetBook() {
		Book book1 = new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));
	 int id=book1.getId();
	 when(bookDao.getBook(id)).thenReturn(book1);
	 assertEquals(1,book1.getId());
	 assertTrue(bookDao.getBook(id) == book1);
	}
	
	@Test
	void testaddBook() {
	List<Book> books= new ArrayList<Book>();
	Book book1 = new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));
	 int size=books.size();
	 books.add(book1);
	 when(bookDao.addBook(book1)).thenReturn(book1);
	 assertEquals(bookDao.addBook(book1),book1);
	 assertTrue(books.size()== size+1);
	}
	
	@Test
	void testupdateBook() {
		Book book1 = new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));
	 bookDao.updateBook(book1);
	verify(bookDao,times(1)).updateBook(book1);
	}
	
	@Test
	void testDeleteBook() {

		Book book1 = new Book(1,"title1", "author1", 10, java.sql.Date.valueOf("2020-12-12"));
	 bookDao.deleteBook(book1.getId());
	verify(bookDao,times(1)).deleteBook(book1.getId());
	}
}
