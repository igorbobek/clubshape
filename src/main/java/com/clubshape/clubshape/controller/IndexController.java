package com.clubshape.clubshape.controller;

import com.clubshape.clubshape.entity.Club;
import com.clubshape.clubshape.entity.League;
import com.clubshape.clubshape.entity.Player;
import com.clubshape.clubshape.repository.ClubRepository;
import com.clubshape.clubshape.repository.PlayerRepository;
import com.clubshape.clubshape.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    ClubRepository clubRepository;

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("user", userService.findByName(auth.getName()));
        modelAndView.addObject("clubs", clubRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/")
    public void index(HttpServletResponse response) throws IOException{
        response.sendRedirect("/");
    }

    @GetMapping("/club/{id}")
    public ModelAndView club(@PathVariable(value = "id") String strId){
        long id;
        try{
            id = Long.parseLong(strId);
        }catch (NumberFormatException e ){
            System.err.println(e.getMessage());
            return new ModelAndView("redirect:/");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("club");
        modelAndView.addObject("user", userService.findByName(auth.getName()));
        if(clubRepository.findById(id).isPresent()) {
            modelAndView.addObject("club", clubRepository.findById(id).get());
        }else{
            return new ModelAndView("redirect:/");
        }
        return modelAndView;
    }

}
