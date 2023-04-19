package com.bilgeadam.repository;

import com.bilgeadam.entity.User;
import com.bilgeadam.utility.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepository {

    /*
        findAll methodu yazalım tum userları lısteleyelım, List donsun

     */
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    public UserRepository () {
        entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }
    public List<User> findAll() {
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root);
        List<User> userList = entityManager.createQuery(userCriteriaQuery).getResultList();
        return userList;

    }
}
