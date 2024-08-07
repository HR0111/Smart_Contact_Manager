package com.hr.scmhr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.User;
import forms.userForm;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import services.userServiceInterface;

@Controller
@Builder
@RestController
@RequiredArgsConstructor
public class PageController {

    @Autowired
    private final userServiceInterface userServiceInterface;

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/services")
    public String services(){
        return "services";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model){

        userForm userForm = new userForm();
        
        model.addAttribute("userForm" , userForm);

        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute userForm userForm){
                                                // userForm me data hai humara

    //to abhi hume hamare user me data dalna padega

    // User user = User.builder()
    //     .name(userForm.getEmail())
    //     .build();

    User user = new User();
    user.setEmail(userForm.getEmail());   
     user.setAbout(userForm.getAbout());
     user.setAbout(userForm.getName());
     user.setAbout(userForm.getPassword());


     userServiceInterface.saveUser(user);
        

        return "redirect:/register";

    }
}
