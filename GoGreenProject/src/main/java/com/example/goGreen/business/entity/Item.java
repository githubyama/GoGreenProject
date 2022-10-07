package com.example.goGreen.business.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    //@Column(name ="Details", nullable = false)
    private String details;
    private int postalCode;

    private String pickUpDate;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String photo;

    //field for owner with user id as a value

    public Item() {
    }

    public Item(Long id, String title, String description, int postalCode, String pickUpDate, String photo) {
        this.id = id;
        this.title = title;
        this.details = description;
        this.postalCode = postalCode;
        this.pickUpDate = pickUpDate;
        this.photo = photo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}



