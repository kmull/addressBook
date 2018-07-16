package com.addressBook.repository;

import com.addressBook.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
            log.info("Something goes wrong !!!");
            return null;
        }
    }
}
