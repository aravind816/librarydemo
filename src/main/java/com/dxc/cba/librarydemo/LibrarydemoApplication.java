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
import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@OpenAPIDefinition
public class LibrarydemoApplication {

	private static final Logger log = LoggerFactory.getLogger(LibrarydemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LibrarydemoApplication.class, args);
	}

}
