package com.addressBook.dao;

import com.addressBook.controler.Controler;
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
    private Logger log = LoggerFactory.getLogger(OneToOneManagedBean.class);

    @Inject
    private UserRepository userRepository;
    private User user = new User();
    private Address address = new Address();
    private String names;
    private boolean messageErrorAddUser = true;

    public void addOneToOneData(User user, Address address) {
        log.info(LOG_ADD_DATA);
        messageErrorAddUser = Controler.checkIfUserError(getUserLists(), user);

        if(!messageErrorAddUser){
            log.info(user.getName() + " " + user.getSurname() + " już istnieje w bazie danych");
            return;
        }
        user.setAddress(address);
        userRepository.addUser(user);
    }

    public List<User> getUserLists() {
        return userRepository.getUsers();
    }

    public List<String> getUsersNames() {
        List<String> resultList = new ArrayList<>();
        resultList.add(" -- select -- ");

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

    public boolean isMessageErrorAddUser() {
        return messageErrorAddUser;
    }

    public void setMessageErrorAddUser(boolean messageErrorAddUser) {
        this.messageErrorAddUser = messageErrorAddUser;
    }
}
