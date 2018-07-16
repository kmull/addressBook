package com.addressBook.repository;

import com.addressBook.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AddressRepository {
    private Logger log = LoggerFactory.getLogger(AddressRepository.class);

    @PersistenceContext(name = "pUnit")
    private EntityManager entityManager;

    public void addAddress(Address address) {
        if(address.getCity() == null){
            log.info("address is empty (null)");
        } else {
            try {
                entityManager.persist(address);
                log.info(address.getId() + " " + address.getCity() + " saved correctly.");
            } catch (Exception e) {
                log.info("Something goes wrong -- AddressRepository -- !!!");
                log.info("log: " + e.getMessage());
            }
        }
    }

    public List<Address> getAddress(){
        return entityManager.createNamedQuery("address.getList").getResultList();
    }

    public Address findAddres(long i){
        return entityManager.find(Address.class, 1L);
    }

}
