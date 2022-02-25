package com.dxc.cba.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class books {

    @Id
    @GeneratedValue
    private  Long  id;

    private Long isbn_number;

    private String book_title;

    private String author_name;

    private Date published_on;

    private Date create_time;

    private Date update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(Long isbn_number) {
        this.isbn_number = isbn_number;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Date getPublished_on() {
        return published_on;
    }

    public void setPublished_on(Date published_on) {
        this.published_on = published_on;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "books [author_name=" + author_name + ", book_title=" + book_title + ", create_time=" + create_time
                + ", id=" + id + ", isbn_number=" + isbn_number + ", published_on=" + published_on + ", update_time="
                + update_time + "]";
    }
    

    
}
