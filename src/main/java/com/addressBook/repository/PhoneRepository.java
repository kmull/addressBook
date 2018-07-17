package com.addressBook.repository;

import com.addressBook.domain.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
            } catch (Exception e) {
                log.info("Something goes wrong -- Phone -- !!!");
            }
        }
    }
}
