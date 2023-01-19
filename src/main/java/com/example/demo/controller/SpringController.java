package com.example.demo.controller;

import com.example.demo.model.CritereChiffre;
import com.example.demo.model.CritereLettre;
import com.example.demo.model.User;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SpringController {
    @Autowired
    CritereChiffreService critereChiffreService;

    @Autowired
    CritereLettreService critereLettreService;

    @Autowired
    DiscoursService discoursService;

    @Autowired
    InfoChiffreService infoChiffreService;

    @Autowired
    InfoLettreService infoLettreService;

    @Autowired
    RechercherChiffreService rechercherChiffreService;

    @Autowired
    RechercherLettreService rechercherLettreService;

    @Autowired
    UserService userService;

    @Autowired
    ValeurCritereService valeurCritereService;

    @Autowired
    ValeurMotService valeurMotService;

    @Autowired
    FonctionService fonctionService;

    @GetMapping(value = "/getcriterechiffre")
    public Iterable<CritereChiffre> getCritereChiffre(){
        return critereChiffreService.findAll();
    }

    @GetMapping(value="/getCritereLettre")
    public List<CritereLettre> getCritereLettre(){
        return critereLettreService.getAll();
    }

    @GetMapping(value = "/getmate1/{id}")
    public List<User> getmate(@PathVariable("id") Integer id, Model m){
        User one=userService.findById(id);
        List<User> all=fonctionService.compatible(one);
        m.addAttribute("liste",all);
        return all;
    }


    @GetMapping(value = "/alluser")
    public Iterable<User> listeUtilisateur(Model m){
        m.addAttribute("liste",userService.allUser());
        User user1=new User("Jean","Jean",0,14.0);
        User user2=new User("Jeanne","Jeanne",1,14.0);
        User user3=new User("Julie","Julie",1,14.0);
        //userService.save(user1);
        //userService.save(user2);
        //userService.save(user3);
        return userService.findAll();
    }
}
