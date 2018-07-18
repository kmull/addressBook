package com.addressBook.repository;

import com.addressBook.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepository {

    private final String P_UNIT = "pUnit";
    private Logger log = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext(unitName = P_UNIT)
    private EntityManager entityManager;

    public void addUser(User user) {
        if (user == null) {
            log.info("user is empty (null)");
        } else {
            try {
                entityManager.persist(user);
                log.info("User: " + user.getName() + " " + user.getSurname() + " saved correctly.");
            } catch (Exception e) {
                log.info("Something goes wrong -- User -- !!!");
            }
        }
    }

    public List<User> getUsers() {
        try {
            return entityManager.createNamedQuery("user.getList").getResultList();
        } catch (Exception e) {
            log.info("Something goes wrong -- getUsers -- !!!");
            return null;
        }
    }

    public User getUserId(String name, String surname) {
        try {
            return (User) entityManager.createNamedQuery("user.getId")
                    .setParameter("name", name)
                    .setParameter("surname", surname)
                    .getSingleResult();

        } catch (NoResultException e) {
            log.info("Something goes wrong -- getUserId -- !!!");
            return null;
        }
    }

    public List<User> getDataJoinColummns() {
//        List list = entityManager.createQuery("SELECT DISTINCT p FROM User d JOIN d.address e " +
//                "JOIN ")

//        return entityManager.createQuery("SELECT User, Phone FROM " +
//                "User user " +
//                "JOIN Phone phone ")
//                .getResultList();

//        return entityManager.createQuery("SELECT User.name, User.surname, " +
//                "Phone.type, Phone.number " +
//                "FROM User JOIN Phone ").getResultList();
//
//        return entityManager.createQuery("SELECT a, b FROM " +
//                "User a JOIN a.phones b ")
//                .getResultList();

        return (List<User>) entityManager.createQuery("SELECT e FROM User e").getResultList();
    }
}
