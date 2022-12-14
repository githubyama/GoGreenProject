package com.example.goGreen.business.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;


    private String password;

    private String phone;


    private String email;

//    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Item> offered;
//
//   @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Item> wanted;


    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Item> getOffered() {
//        return offered;
//    }
//
//    public void setOffered(List<Item> offered) {
//        this.offered = offered;
//    }
//
//    public List<Item> getWanted() {
//        return wanted;
//    }
//
//    public void setWanted(List<Item> wanted) {
//        this.wanted = wanted;
//    }
}
