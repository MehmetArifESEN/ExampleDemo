package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date date=new Date();
    private Long userId;

    public Post( String content, Date date, Long userId) {

        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Post() {
    }

    public Post( String content, Long userId) {

        this.content = content;
        this.userId = userId;
    }
}
