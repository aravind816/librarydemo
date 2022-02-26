package com.dxc.cba.librarydemo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dxc.cba.librarydemo.model.Book;
import com.dxc.cba.librarydemo.presistence.BookRepository;
import com.dxc.cba.librarydemo.presistence.CustomBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository<Book> bookRepository;

    @Autowired
    private CustomBookRepo bookRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("librarytopic", msg);
    }

    @KafkaListener(topics = "librarytopic", groupId = "reader")
    public void receiveMessage(String message) {
        System.out.println("Received Message in library group reader: ####>> " + message);
    }

    public List<Book> getAllBooks() {
        sendMessage("Book Record searched: >> ");
        List<Book> book = new ArrayList<>();
        bookRepository.findAll().forEach(book::add);
        return book;
    }

    public List<Book> getAllSortedBooks() {
        sendMessage("Book Records searched by sorting the title : >> ");
        return bookRepository.findAll(Sort.by("title"));
    }

    public void addBook(Book bookRecord) {
        bookRepository.save(bookRecord);
        sendMessage("Book Record added: >> "+bookRecord.toString());
    }

    public void updateBook(Book bookRecord) {
        bookRepository.save(bookRecord);
        sendMessage("Book Record updated: >> "+bookRecord.toString());
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
        sendMessage("Book Record deleted: >> "+id.toString());
    }

    public List<Book> getFilteredBooks(String author, String title, Long isbn, Date published) {
        sendMessage("Book Record searched: >> "+"#### Author >> " + author + " #### title >> " + title + " #### isbn >> " + isbn
            + " #### published >> " + published);

        if (isbn != null && author != null && title != null) {
            
            return bookRepository.findByAuthorContainingOrTitleContainingOrIsbnOrPublished(author, title, isbn,
                    published);
        } else {
            return bookRepo.findBooksByCriteria(author, title, isbn, published);
        }
    }

}
