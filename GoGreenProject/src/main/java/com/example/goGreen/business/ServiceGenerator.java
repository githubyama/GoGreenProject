package com.example.goGreen.business;

import com.example.goGreen.business.entity.Client;
import com.example.goGreen.business.entity.Item;
import com.example.goGreen.repository.DataRepository;
import com.example.goGreen.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@SessionScope
public class ServiceGenerator {

    @Autowired
    DataRepository dataRep;

    @Autowired
    ItemRepository itemRep;

    Client client;
    Item item;


    public boolean login(LoginForm loginForm) {
        List<Client> cList = dataRep.findByEmail(loginForm.email);

        if (cList.size() > 0) {
            Client client = cList.get(0);
            if (loginForm.password.equals(client.getPassword())) {
                this.client = client;
                return true;
            }
        }
        return false;
    }

    public Boolean signUp(Client client) {
        List<Client> cList = dataRep.findByEmail(client.getEmail());
        if (cList.size() > 0) {
            return false;
        } else {
//            client.setOffered(new ArrayList<>());
//            client.setWanted(new ArrayList<>());
            this.client = dataRep.save(client);
            return true;
        }
    }

    public void saveOfferToDB(MultipartFile file, String title, String details
            , int postalCode, String pickUpDate) {
        Item items = new Item();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //upload file - server?
        items.setPhoto(fileName);
        //save the file?? actual picture should be saved in teh file !!!
        items.setDetails(details);

        items.setTitle(title);
        items.setPostalCode(postalCode);
        items.setPickUpDate(pickUpDate);
        itemRep.save(items);
    }

    public List<Item> getAllItems() {
       return itemRep.findAll();
    }
}
