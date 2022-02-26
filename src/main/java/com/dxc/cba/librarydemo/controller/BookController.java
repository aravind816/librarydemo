package com.dxc.cba.librarydemo.controller;

import java.sql.Date;
import java.util.List;

import com.dxc.cba.librarydemo.model.Book;
import com.dxc.cba.librarydemo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "This method will giva all the records stored in the library")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all the records from database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Service not available", content = @Content)
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }




    @Operation(summary = "This method will giva all the records filtered based on Author, ISBN number, Title, Published date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all matching records from library", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Service not available", content = @Content)
    })
    @GetMapping("/filterbooks/{isbn}{author}{title}{publishedon}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks(@PathVariable("isbn") final Long isbn,@PathVariable("author") final String author, @PathVariable("title") final String title,
             @PathVariable("publishedon") final String published) {
        return bookService.getFilteredBooks(author, title, isbn);
    }




    @Operation(summary = "This method will add a new book record with Author, ISBN number, Title & Published date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added a new record to the library", content = @Content),
            @ApiResponse(responseCode = "404", description = "Service not available", content = @Content)
    })
    @PostMapping(value = "/add-book")
    @ResponseStatus(HttpStatus.OK)
    public String addUser(@RequestBody Book bookRecord) {
        bookService.addBook(bookRecord);
        return "Book Added";
    }

    

    @Operation(summary = "This method will update the book record in the library")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the existing record in the library", content = @Content),
            @ApiResponse(responseCode = "404", description = "Service not available", content = @Content)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateBook(
            @PathVariable("id") final Long id, @RequestBody final Book bookRecord) {
        bookRecord.setId(id);
        bookService.addBook(bookRecord);
        return "Book updated";
    }







    @Operation(summary = "This method will delete an existing book with the ID supplied")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted a record from the library with the supplied ID", content = @Content),
            @ApiResponse(responseCode = "404", description = "Service not available", content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBook(
            @PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "Book deleted";
    }

}
