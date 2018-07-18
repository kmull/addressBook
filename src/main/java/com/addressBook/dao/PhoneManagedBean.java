package com.addressBook.dao;

import com.addressBook.domain.Phone;
import com.addressBook.domain.User;
import com.addressBook.repository.PhoneRepository;
import com.addressBook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

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
        String[] namesTab = names.split(" ");

        log.info(namesTab[0] + " " + namesTab[1]);
        user = userRepository.getUserId(namesTab[0], namesTab[1]);

        log.info("addTelephone find userRepository data: " +
                user.getId() + " " + user.getName() + " " + user.getSurname() +
                user.getAge() + " " + user.getGender());

        phone.setUser_phone(user);
        phoneRepository.addTelephone(phone);
    }

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
}

//        user = userRepository.getUserId("Krzysztof", "Muller");
