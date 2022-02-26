package com.dxc.cba.librarydemo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue
    private  Long  id;

    private Long isbn;

    private String title;

    private String author;

    private Date published;

    @JsonIgnore
    private Date createtime=new Date(System.currentTimeMillis());

    @JsonIgnore
    private Date updatetime=new Date(System.currentTimeMillis());




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


    public void setId(Long id2) {
        this.id=id2;
    }
    
}
