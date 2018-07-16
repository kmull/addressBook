package com.addressBook.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ab_Address")
@NamedQuery(name = "address.getList", query = "FROM Address ")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    private String street;
    private String city;

//    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user_address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser_address() {
        return user_address;
    }

    public void setUser_address(User user_address) {
        this.user_address = user_address;
    }

    public String toString() {
        return "Address [" +
                "id= " + id +
                ", street= " + street +
                ", zipCode= " + zipCode +
                ", city= " + city +
                "]";
    }
}
