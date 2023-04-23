package com.bilgeadam.repository;

import com.bilgeadam.entity.Information;
import com.bilgeadam.entity.User;
import com.bilgeadam.utility.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepository {

    /*
        1- findAll methodu yazalım tum userları lısteleyelım, List donsun
        2- findallInformation

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

    public List<Information> findallUSerInformation() {
        CriteriaQuery<Information> informationCriteriaQuery = criteriaBuilder.createQuery(Information.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information"));
        List<Information> informationList = entityManager.createQuery(informationCriteriaQuery).getResultList();
        return informationList;

    }

    public List<String> findAllInformationByName() {
        CriteriaQuery<String> informationCriteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information").get("name"));
        List<String> informationList = entityManager.createQuery(informationCriteriaQuery).getResultList();
        return informationList;

    }

    public List<User> findAllNativeQuery() {
       String sql = "Select * from tbluser";
       List<User> users =  entityManager.createNativeQuery(sql, User.class).getResultList();
       return users;

    }

    public User findById(Long id) {
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"),id));
        User user = entityManager.createQuery(criteriaQuery).getSingleResult();
        return user;

    }
}
