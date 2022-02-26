package com.dxc.cba.librarydemo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {


    @Id
    @GeneratedValue
    private  Long  id;

    private Long isbn;

    private String title;

    private String author;

    private Date published;

    private Date createtime;

    private Date updatetime;


    public Book() {
    }


    public Book(Long isbn, String title, String author, Date published, Date createtime, Date updatetime) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }


    @Override
    public String toString() {
        return "Book [author=" + author + ", createtime=" + createtime + ", id=" + id + ", isbn=" + isbn
                + ", published=" + published + ", title=" + title + ", updatetime=" + updatetime + "]";
    }
    
}
