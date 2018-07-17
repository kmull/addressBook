package com.addressBook.dao;

import com.addressBook.domain.Address;
import com.addressBook.domain.User;
import com.addressBook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "oneBean")
public class OneToOneManagedBean {
    private final String LOG_ADD_DATA = " -- addOneToOneData --";
    private Logger log = LoggerFactory.getLogger(AddressManagedBean.class);

    @Inject
    private UserRepository userRepository;
    private User user = new User();
    private Address address = new Address();
    private String names;

    public void addOneToOneData(User user, Address address) {
        log.info(LOG_ADD_DATA);
        user.setAddress(address);
        userRepository.addUser(user);
    }

    public List<User> getUserLists() {
        return userRepository.getUsers();
    }

    public List<String> getUsersNames() {
        List<String> resultList = new ArrayList<>();
        for (User tmpUser : getUserLists()) {
            resultList.add(tmpUser.getName() + " " + tmpUser.getSurname());
        }
        return resultList;
    }

    /*************** Getters and Setters*****************/

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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
