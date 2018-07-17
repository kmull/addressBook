package com.addressBook.domain;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ab_User")
@NamedQueries({
        @NamedQuery(name = "user.getList", query = "FROM User"),
//        @NamedQuery(name = "user.getId", query = "SELECT u FROM User u ORDER BY u.name, u.surname")
        @NamedQuery(name = "user.getId", query = "SELECT  u FROM  User u " +
                "WHERE  u.name = :name AND u.surname = :surname")
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    private String name;
    private String surname;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_phone", orphanRemoval = true)
    private List<Phone> phones;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "ab_address_fk")
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [" +
                "id= " + id +
                ", name= " + name +
                ", surname= " +
                ", age= " + age +
                ", gender= " + gender +
                "]";
    }
}


