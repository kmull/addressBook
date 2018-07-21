package com.addressBook.dao;

import com.addressBook.domain.Phone;
import com.addressBook.domain.User;
import com.addressBook.repository.PhoneRepository;
import com.addressBook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "phoneBean", eager = true)
public class PhoneManagedBean {
    private Logger log = LoggerFactory.getLogger(UserRepository.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private PhoneRepository phoneRepository;

    private Phone phone = new Phone();
    private User user = new User();
    private String names;

    public void addTelephone(Phone phone) {
        log.info(phone.getType() + " " + phone.getNumber());

        phone.setUser_phone(findUser());
        phoneRepository.addTelephone(phone);

        log.info("addTelephone find userRepository data: " +
                user.getId() + " " + user.getName() + " " + user.getSurname() +
                user.getAge() + " " + user.getGender());
    }

    public void addNames(String names) {
        this.names = names;
    }

    public List<Phone> getPhoneList() {
        return phoneRepository.getPhoneListRepository();
    }

    public List<Phone> getTelephones() {
        return phoneRepository.findTelephonesRepository(findUser().getId());
    }

    private User findUser() {
        String[] namesTab = names.split(" ");
        log.info(namesTab[0] + " " + namesTab[1]);
        return userRepository.getUserId(namesTab[0], namesTab[1]);
    }

    /*************Getters and setters******************/
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
