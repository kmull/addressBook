package com.addressBook.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ab_Phone")
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    private String type;
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user_phone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(User user_phone) {
        this.user_phone = user_phone;
    }

    @Override
    public String toString() {
        return "Phone [" +
                "id= " + id +
                ", type= " + type +
                ", number= " + number +
                "]";
    }
}
