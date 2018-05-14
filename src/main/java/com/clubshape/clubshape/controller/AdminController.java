package com.clubshape.clubshape.controller;

import com.clubshape.clubshape.entity.*;
import com.clubshape.clubshape.repository.ClubFormRepository;
import com.clubshape.clubshape.repository.ClubRepository;
import com.clubshape.clubshape.repository.FormRepository;
import com.clubshape.clubshape.repository.PlayerRepository;
import com.clubshape.clubshape.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    FormRepository formRepository;
    @Autowired
    ClubFormRepository clubFormRepository;
    @Autowired
    PlayerRepository playerRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/addForm")
    public ModelAndView addForm(ModelAndView modelAndView){
        modelAndView.setViewName("add_form");
        modelAndView.addObject("form", new Form());
        modelAndView.addObject("user", userService.findByName("admin"));
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/admin/addForm")
    public ModelAndView addForm(@ModelAttribute("form") @Valid Form formForm,
                                ModelAndView modelAndView,
                                @RequestParam("club") String clubStrForm
                                ){
        ClubForm clubForm = new ClubForm();
        if (clubRepository.findByName(clubStrForm) != null){
            clubForm.setForm(formForm);
            clubForm.setClub(clubRepository.findByName(clubStrForm));
            clubFormRepository.save(clubForm);
        }
        return new ModelAndView("redirect:/");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/addClub")
    public ModelAndView addClub(ModelAndView modelAndView){
        modelAndView.setViewName("add_club");
        modelAndView.addObject("club", new Club());
        modelAndView.addObject("user", userService.findByName("admin"));
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/admin/addClub")
    public ModelAndView addClub(@ModelAttribute("club") @Valid Club clubForm){
        if (clubRepository.findByName(clubForm.getName()) == null){
            clubRepository.save(clubForm);
        }
        return new ModelAndView("redirect:/");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/addPlayer")
    public ModelAndView addPlayer(ModelAndView modelAndView){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("add_player");
        modelAndView.addObject("player", new Player());
        modelAndView.addObject("user", userService.findByName(auth.getName()));
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/admin/addPlayer")
    public ModelAndView addPlayer(@ModelAttribute("player") @Valid Player playerForm){
        if(clubRepository.findByName(playerForm.getClub().getName()) != null){
            playerForm.setClub(clubRepository.findByName(playerForm.getClub().getName()));
            playerRepository.save(playerForm);
        }
        return new ModelAndView("redirect:/");
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/deletePlayer")
    public  String deletePlayer(@RequestParam("playerId") String idStr, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        long id;

        try{
            id = Long.parseLong(idStr);
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
            return "redirect:"+referer;
        }



        if(playerRepository.findById(id).isPresent()){
            Player player= playerRepository.findById(id).get();
            player.setClub(null);
            playerRepository.save(player);
            playerRepository.delete(playerRepository.findById(id).get());
        }
        return "redirect:"+referer;
    }



}
