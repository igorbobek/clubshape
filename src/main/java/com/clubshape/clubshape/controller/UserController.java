package com.clubshape.clubshape.controller;

import com.clubshape.clubshape.entity.User;
import com.clubshape.clubshape.entity.UserFormPlayer;
import com.clubshape.clubshape.repository.FormRepository;
import com.clubshape.clubshape.repository.PlayerRepository;
import com.clubshape.clubshape.repository.UserFormRepository;
import com.clubshape.clubshape.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserFormRepository userFormRepository;
    @Autowired
    FormRepository formRepository;
    @Autowired
    PlayerRepository playerRepository;

    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }


    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute("user") @Valid User userForm, @RequestParam("matchingPassword") String matchPass){
        ModelAndView modelAndView = new ModelAndView();
        if(userForm.getName().equals("") || userForm.getEmail().equals("") || userForm.getPassword().equals("")){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", "Вводимые поля не должны быть пустыми!");
            return modelAndView;
        }

        if (!userForm.getPassword().equals(matchPass)){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", "Оба введенных пароля должны быть идентичны!");
            return modelAndView;
        }
        try{
            userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
            userService.save(userForm);
            modelAndView = new ModelAndView(new RedirectView("/"));
            return modelAndView;
        }catch (Exception e){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", e.getMessage());
            System.err.println(e.getMessage());
        }
        return modelAndView;
    }

    @Secured("ROLE_USER")
    @PostMapping("/addFormForMe")
    public String addFormForMe(@RequestParam("formId") String formIdStr, @RequestParam("playerId") String playerIdStr, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        long playerId, formId;
        try{
            playerId = Long.parseLong(playerIdStr);
            formId = Long.parseLong(formIdStr);
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
            return "redirect:"+ referer;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        UserFormPlayer userForm = new UserFormPlayer();
        userForm.setDate(new Date());
        userForm.setAddress(user.getAddress());
        userForm.setUser(user);
        if(formRepository.findById(formId).isPresent() && playerRepository.findById(playerId).isPresent()) {
            userForm.setForm(formRepository.findById(formId).get());
            userForm.setPlayer(playerRepository.findById(playerId).get());
        }else{return "redirect:"+ referer;}
        userFormRepository.save(userForm);
        return "redirect:"+ referer;
    }

    @Secured("ROLE_USER")
    @GetMapping("/cart")
    public ModelAndView cart(){
        ModelAndView modelAndView = new ModelAndView("cart");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        modelAndView.addObject("userFormSet",user.getUserFormSet());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
