package com.dxc.cba.librarydemo.presistence;

import java.sql.Date;
import java.util.List;

import com.dxc.cba.librarydemo.model.Book;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository<Books> extends CrudRepository<Book,Long>{
    List<Book> findByAuthorContainingOrTitleContainingOrIsbnOrPublished(String author,String title,Long isbn,Date published);
    List<Book>  findByAuthorContaining(String author);
    List<Book>  findByIsbn(long isbn);
    List<Book>  findByPublished(Date published);

    @Query(value = "SELECT b FROM Book b")
    List<Book> findAllBooks(Sort sort);
    List<Book> findAll(Sort by);
}
