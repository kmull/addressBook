package com.addressBook.navigation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navig", eager = true)
@RequestScoped
public class NavigationBean {

    @ManagedProperty(value = "#{param.pageId}")
    private String pageId;

    private final String errorMessage = "Not Found";
    Logger log = LoggerFactory.getLogger(NavigationBean.class);

    public String showPage() {

        String check;
        if (pageId == null) {
            log.info("showPage: " + errorMessage);
            check = errorMessage;
        } else if (pageId.equals("1")) {
            check = "addData";
        } else if (pageId.equals("2")) {
            check = "getData";
        } else if (pageId.equals("3")) {
            check = "findData";
//        } else if (pageId.equals("4")) {
//            check = "addUser_ver2";
//        } else if (pageId.equals("5")) {
//            check = "getUser_ver2";
//        } else if (pageId.equals("6")) {
//            check = "getPhones";
        } else {
            check = "index";
        }
        log.info("showPage started, option: " + check);
        return check;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}
