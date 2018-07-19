package com.addressBook.repository;

import com.addressBook.domain.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PhoneRepository {

    private final String P_UNIT = "pUnit";
    private Logger log = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext(unitName = P_UNIT)
    private EntityManager entityManager;

    public void addTelephone(Phone phone) {
        if (phone.getNumber() == null) {
            log.info(" -- phone is empty (null) --");
        } else {
            try {
                entityManager.persist(phone);
                log.info("Phone: " + phone.getType() + " " + phone.getNumber() + " saved correctly.");
            } catch (NoResultException e) {
                log.info("Something goes wrong -- Phone -- !!!");
            }
        }
    }

    public List<Phone> findTelephones(long findId) {
        if (findId == 0) {
            log.info(" -- user_id not found --");
            return null;
        } else {
            try {
                return entityManager.createNamedQuery("phone.findNumbers")
                        .setParameter("findId", findId)
                        .getResultList();
            } catch (NoResultException e) {
                log.info("Something goes wrong -- getUserId -- !!!");
                return null;
            }
        }
    }
}
