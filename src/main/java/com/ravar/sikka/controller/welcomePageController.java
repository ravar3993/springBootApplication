package com.ravar.sikka.controller;

import com.ravar.sikka.model.User;
import com.ravar.sikka.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class welcomePageController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/")
    public ModelAndView welcomeMessage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/signUp")
    public ModelAndView signUp(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "confirmPassword") String confirmPassword,
                               ModelAndView modelAndView, HttpSession httpSession){

        password = DigestUtils.sha256Hex(password);
        confirmPassword = DigestUtils.sha256Hex(confirmPassword);

        if (password.equals(confirmPassword)){
            int userCount = userRepository.checkUserByUserName(userName);
            if (userCount > 0){
                modelAndView.addObject("message", "Username already exists");
                modelAndView.setViewName("error");
            }else{
                User user = new User();
                user.setPassword(password);
                user.setUserName(userName);
                user.setEmail(email);
                userRepository.save(user);
                httpSession.setAttribute("userName", userName);
                modelAndView.addObject("userName", userName);
                modelAndView.setViewName("home");
            }
        }else{
            modelAndView.addObject("message", "Please check the password and try again");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/signIn")
    public ModelAndView signIn(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "password") String password, ModelAndView modelAndView){

        password = DigestUtils.sha256Hex(password);
        User user = userRepository.getUserByLogin(userName,password);
        String user_name = "";
        if(user!=null){
            user_name = user.getUserName();
            modelAndView.addObject("userName", user_name);
            modelAndView.setViewName("home");
        }else {
            modelAndView.addObject("message", "The user does not exist");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
