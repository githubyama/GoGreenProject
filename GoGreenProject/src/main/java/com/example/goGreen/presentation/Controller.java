package com.example.goGreen.presentation;

import com.example.goGreen.business.LoginForm;
import com.example.goGreen.business.ServiceGenerator;
import com.example.goGreen.business.entity.Client;
import com.example.goGreen.business.entity.Item;
import com.example.goGreen.repository.DataRepository;
import com.example.goGreen.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ServiceGenerator sg;


    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "loginpage";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute LoginForm loginForm, Model model, RedirectAttributes ra) {

        if (sg.login(loginForm)) {
            List<Item> items = sg.getAllItems();
            model.addAttribute("items", items);
            return "productpage";
        } else {
            ra.addFlashAttribute("message", "Wrong try again!");
            return "redirect:/";
        }
    }

    @GetMapping("/signup")
    public String registration(Model model) {
        model.addAttribute("client", new Client());
        return "signuppage";
    }

    @PostMapping("/signup")
    public String createAccount(@ModelAttribute Client client, Model model) {
        if (sg.signUp(client)) {
            List<Item> items = sg.getAllItems();
            model.addAttribute("items", items);
            return "productpage";
        }
        model.addAttribute("message", "Email address is already in use.");
        return "redirect:/signup";
    }

    @GetMapping("/offer")
    public String createOffer(Model model) {
        model.addAttribute("item", new Item());
        return "offerpage";
    }

    @PostMapping(path = "/offer", consumes = {MULTIPART_FORM_DATA_VALUE})
    public String saveProduct(@RequestParam("file") MultipartFile file,
                              @RequestParam("title") String title,
                              @RequestParam("details") String details,
                              @RequestParam("postalcode") int postalCode,
                              @RequestParam("pickupdate") String pickUpDate,
                              Model model) {
        sg.saveOfferToDB(file, title, details, postalCode, pickUpDate);
        List<Item> items = sg.getAllItems();
        model.addAttribute("items", items);
        return "productpage";
    }


}
