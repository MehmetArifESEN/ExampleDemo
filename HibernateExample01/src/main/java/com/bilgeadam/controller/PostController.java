package com.bilgeadam.controller;

import com.bilgeadam.entity.Post;
import com.bilgeadam.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class PostController {

    public static void main(String[] args) {
        //createPost();

    }

    public static void createPost() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Post post = new Post("içerik1" , new Date(), 1L);
        Post post2 = new Post("içerik2" , new Date(), 2L);
        Post post3 = new Post("içerik3" , 1L);
        Post post4 = new Post("içerik4" , 1L);
        Post post5 = new Post("içerik5" , 1L);

        session.save(post);
        session.save(post2);
        session.save(post3);
        session.save(post4);
        session.save(post5);
        transaction.commit();
        session.close();


    }

}
