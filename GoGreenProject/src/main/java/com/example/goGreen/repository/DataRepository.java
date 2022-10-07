package com.example.goGreen.repository;

import com.example.goGreen.business.entity.Client;
import com.example.goGreen.business.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository <Client, Long> {

   // List<Client> findByName(String clientName);

    List<Client> findByEmail(String email);

    //List<Item> findByTitle(String title);

    // List<Item> findAll(String title);
}
