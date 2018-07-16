package com.addressBook.dao;

import com.addressBook.domain.Address;
import com.addressBook.domain.User;
import com.addressBook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean(name = "oneBean")
public class OneToOneBean {
    private final String LOG_ADD_DATA = " -- addOneToOneData --";
    private Logger log = LoggerFactory.getLogger(AddressBean.class);

    @Inject
    private UserRepository userRepository;
    private User user = new User();
    private Address address = new Address();

    public void addOneToOneData(User user, Address address) {
        log.info(LOG_ADD_DATA);
        user.setAddress(address);
        userRepository.addUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
