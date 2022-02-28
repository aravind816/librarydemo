package com.dxc.cba.librarydemo.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import com.dxc.cba.librarydemo.model.Book;
import com.dxc.cba.librarydemo.service.BookService;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.jboss.logging.Logger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class BookController {
        Logger logger = LoggerFactory.logger(BookController.class);

        @Autowired
        private BookService bookService;

        @Operation(summary = "This method will add a new book record with Author, ISBN number, Title & Published date")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Added a new record to the library", content = @Content),
                        @ApiResponse(responseCode = "404", description = "Service not available", content = @Content)
        })
        @PostMapping(value = "/book")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody Book addBook(@Valid @RequestBody Book bookRecord) {
                logger.info(bookRecord.toString());
                logger.info("####Adding a new book...");
                bookRecord.setCreatetime(new Date(System.currentTimeMillis()));
                bookRecord.setUpdatetime(new Date(System.currentTimeMillis()));
                return bookService.addBook(bookRecord);
        }
        /*
        @Operation(summary = "This method will give all the records stored in the library")
        @GetMapping("/")
        @ResponseStatus(HttpStatus.OK)
        */
        public List<Book> getAllBooks() {
                logger.info("####Retriving all books...");
                return bookService.getAllBooks();
        }

        @Operation(summary = "This method will return all the records or filtered records based on Author, ISBN number, Title, Published date")
        @GetMapping("/book")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody List<Book> getFilteredBooks(@RequestParam(required = false) final Long isbn,
                        @RequestParam(required = false) final String author,
                        @RequestParam(required = false) final String title,
                        @RequestParam(required = false) final Date published_date) {
                logger.info("####Searching books by keywords...");
                logger.info("#### Author >> " + author + " #### title >> " + title + " #### isbn >> " + isbn
                                + " #### published_date >> " + published_date);
                                return bookService.getFilteredBooks(author, title, isbn, published_date);
        }

        @Operation(summary = "This method will update the book record in the library")
        @PutMapping("/book")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody Book updateBook(
                        @RequestParam("id") final Long id,@Valid @RequestBody final Book bookRecord) {
                logger.info("####Updating book >>> " + id);
                bookRecord.setId(id);
                bookRecord.setUpdatetime(new Date(System.currentTimeMillis()));
                return bookService.updateBook(bookRecord);
        }

        @Operation(summary = "This method will delete an existing book with the ID supplied")
        @DeleteMapping("/book")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody String deleteBook(
                        @RequestParam("id") Long id) {
                logger.info("####Deleting the book >>> " + id);
                bookService.deleteById(id);
                return "Book is deleted Successfully";
        }


        @Operation(summary = "This method will send a message to kafka topic")
        @PostMapping("/message")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody String sendMessage(
                        @RequestParam("message") String message) {
                logger.info("####Posting a message to kafka >>> " + message);
                bookService.sendMessage(message);
                return "Your message is posted to Kafk topic";
        }

}


