package com.dxc.cba.librarydemo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import com.dxc.cba.librarydemo.controller.BookController;
import com.dxc.cba.librarydemo.model.Book;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.jboss.logging.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class LibrarydemoApplicationTests {


	Logger logger = LoggerFactory.logger(BookController.class);

	
	@Autowired
	BookController bcontroller;

	static Book testBook=new Book();
	static Date testDate=new Date(System.currentTimeMillis());


	@Test
	@Order(1)
	void contextLoads() {
		assertThat(bcontroller).isNotNull();
	}

	@Test
	@Order(2)
	void testCreate(){
		
		Book response=bcontroller.addBook(new  Book(1234567890123L, "Superman is dead", "Batman", testDate, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
		assertThat(response).isNotNull();
		testBook=response;
		logger.info(" Test Book Created ## >> "+response.toString());
	}

	@Test
	@Order(3)
	void testSearch(){
		List<Book> response=bcontroller.getAllBooks();
		assertThat(response).isNotNull();
		assertThat(response).size().isGreaterThan(0);
		logger.info(" All books retrived ## >> "+response.size());
	}


	@Test
	@Order(4)
	void testFilterSearch(){
		List<Book> response=bcontroller.getFilteredBooks(1234567890123L, "Batman", "Superman is dead", testDate);
		assertThat(response).isNotNull();
		assertThat(response).size().isGreaterThan(0);
		logger.info(" Filtered Books retrived ## >> "+response.size());
	}

	@Test
	@Order(5)
	void testUpdate(){
		testBook.setTitle("I am BATMAN :) ");
		Book response=bcontroller.updateBook(testBook.getId(), testBook);
		assertThat(response).isNotNull();
		assertEquals(response.getTitle(), "I am BATMAN :) ");
		logger.info(" Test Book Updated ## >> "+response.toString());
	}

	@Test
	@Order(6)
	void testDelete(){
		String response=bcontroller.deleteBook(testBook.getId());
		assertEquals(response, "Book deleted Successfully");
	}




}
