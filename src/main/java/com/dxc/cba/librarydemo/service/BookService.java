package com.dxc.cba.librarydemo.service;

import java.util.ArrayList;
import java.util.List;

import com.dxc.cba.librarydemo.model.Book;
import com.dxc.cba.librarydemo.presistence.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository<Book> bookRepository;

    public List<Book> getAllBooks() {
        List<Book> book = new ArrayList<>();
        bookRepository.findAll().forEach(book::add);
        return book;
    }

    public void addBook(Book bookRecord) {
        bookRepository.save(bookRecord);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getFilteredBooks(String author,String title, Long isbn){
        return bookRepository.findByAuthorContainingOrTitleContainingOrIsbn(author, title, isbn);
    }

}
