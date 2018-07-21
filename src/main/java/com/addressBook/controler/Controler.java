package com.addressBook.controler;

import com.addressBook.dao.OneToOneManagedBean;
import com.addressBook.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Controler {
    private static Logger log = LoggerFactory.getLogger(Controler.class);

    public static boolean checkIfUserError(List<User> userList, User user) {

        for (User tmpUser : userList) {
            if (tmpUser.getName().equals(user.getName()) &&
                    tmpUser.getSurname().equals(user.getSurname())) {
                return false;
            }
        }
        return true;
    }
}
