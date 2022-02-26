package com.dxc.cba.librarydemo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dxc.cba.librarydemo.model.Book;
import com.dxc.cba.librarydemo.presistence.BookRepository;
import com.dxc.cba.librarydemo.presistence.CustomBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository<Book> bookRepository;


    @Autowired
    CustomBookRepo bookRepo;

    public List<Book> getAllBooks() {
        List<Book> book = new ArrayList<>();
        bookRepository.findAll().forEach(book::add);
        return book;
    }


    public List<Book> getAllSortedBooks() {
        
        return bookRepository.findAll(Sort.by("name"));
    }

    public void addBook(Book bookRecord) {
        bookRepository.save(bookRecord);
    }

    public void updateBook(Book bookRecord) {
        bookRepository.save(bookRecord);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getFilteredBooks(String author,String title, Long isbn,Date published){

        if (isbn != null && author != null && title != null) {
            return bookRepository.findByAuthorContainingOrTitleContainingOrIsbnOrPublished(author, title, isbn, published);
    } else {
            return bookRepo.findBooksByCriteria(author, title, isbn, published);
    }
    }

}
