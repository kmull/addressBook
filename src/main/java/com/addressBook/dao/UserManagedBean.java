package com.addressBook.dao;

import com.addressBook.domain.Address;
import com.addressBook.domain.User;
import com.addressBook.repository.AddressRepository;
import com.addressBook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "userBean", eager = true)
public class UserManagedBean {
    private Logger log = LoggerFactory.getLogger(UserManagedBean.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private AddressRepository addressRepository;

    private Address address = new Address();
    private User user = new User();

    public void addUser(User user) {
        log.info("addUser");

        user.setAddress((Address) addressRepository.getAddress());
        log.info("user start adduser");
        userRepository.addUser(user);
        log.info("user " + user.getName() + " added.");
    }

    public List<User> getUserData() {
        log.info("getUserData");
        return userRepository.getUsers();
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
