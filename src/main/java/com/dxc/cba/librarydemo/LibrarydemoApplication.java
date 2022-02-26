package com.dxc.cba.librarydemo;

import java.sql.Date;
import java.util.Optional;

import com.dxc.cba.librarydemo.model.Book;
import com.dxc.cba.librarydemo.presistence.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class LibrarydemoApplication {


	private static final Logger log = LoggerFactory.getLogger(LibrarydemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LibrarydemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepository<Book> repository) {
	  return (args) -> {
		//repository.save(
		//new Book(123456338903L,"I am a developer", "Aravind",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()))
		//);
  
		// fetch all books
		log.info("Books found with findAll():");
		log.info("-------------------------------");
		for (Book book : repository.findAll()) {
		  log.info(book.toString());
		}
		log.info("");
  
		// fetch an individual book by ID
		Optional<Book> book = repository.findById(1L);
		log.info("Book found with findById(1L):");
		log.info("--------------------------------");
		log.info(book.toString());
		log.info("");

		// fetch books by criteria
		log.info("Books found with findByCriteria(''):");
		log.info("--------------------------------------------");
		//repository.findByAuthorContainingOrTitleContainingOrIsbn("","",12345678903L);
		
		repository.findByPublished(new Date(System.currentTimeMillis())).forEach(bok -> {
		  log.info(bok.toString());
		});
		log.info("");
	  };
	}

}
