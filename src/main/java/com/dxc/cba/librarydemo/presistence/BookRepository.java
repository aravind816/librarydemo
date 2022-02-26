package com.dxc.cba.librarydemo.presistence;

import java.sql.Date;
import java.util.List;

import com.dxc.cba.librarydemo.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository<Books> extends CrudRepository<Book,Long>{
    List<Book> findByAuthorContainingOrTitleContainingOrIsbn(String author,String title,Long isbn);
    List<Book>  findByAuthorContaining(String author);
    List<Book>  findByIsbn(long isbn);
    List<Book>  findByPublished(Date published);
}
