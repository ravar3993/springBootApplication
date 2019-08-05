package com.ravar.sikka.controller;

import com.ravar.sikka.model.User;
import com.ravar.sikka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class welcomePageController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/")
    public String welcomeMessage(){
        String name = "Rahul Verma";
        return "welcome";
    }
    @ResponseBody
    @RequestMapping(value = "/signUp")
    public String dbTest(@RequestParam(value = "userName") String userName, @RequestParam(value = "email") String email,
                         @RequestParam(value = "password") String password, @RequestParam(value = "confirmPassword") String confirmPassword ){
        String resp = "SUCCESS";
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        if (password.equals(confirmPassword)){
            user.setPassword(password);
        }else{
            resp = "FAILED";
        }
        userRepository.save(user);
        return resp;
    }
    @ResponseBody
    @RequestMapping(value = "/signIn")
    public String dbGetTest(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password){
        List<User> users = userRepository.getUserByLogin(userName,password);
        String userDetails = "No results found";
        if(users!=null){
            for(User user:users){
                userDetails = "Email is "+user.getEmail();
            }
        }
        return userDetails;
    }
}
