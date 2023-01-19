package com.example.demo.controller;

import com.example.demo.model.*;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AllController {
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



    @RequestMapping(value = "/getquestion")
    public String getQuestion(Model m){
        Iterable<CritereChiffre> v=  critereChiffreService.findAll();
        List<CritereLettre> v1=critereLettreService.getAll();
        m.addAttribute("criterechiffre",v);
        m.addAttribute("criterelettre",v1);
        return "formulaire";
    }
    @RequestMapping(value = "/getinfo")
    public String getInfo(Model m, HttpServletRequest request){
        Iterable<CritereChiffre> v=  critereChiffreService.findAll();
        List<CritereLettre> v1=critereLettreService.getAll();

        m.addAttribute("criterechiffre",v);
        m.addAttribute("criterelettre",v1);

        List<InfoChiffre> chiffres=new ArrayList<>();
        List<InfoLettre> lettres=new ArrayList<>();

        User user=new User();
        user.setNom(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setNote(Double.valueOf(request.getParameter("note")));
        user.setSexe(Integer.valueOf(request.getParameter("sexe")));
        user.setDiscours(request.getParameter(("discours")));

        userService.save(user);

        for (CritereChiffre element : v) {
            InfoChiffre c=new InfoChiffre();
            c.setIdCritereChiffre(element.getId());
            c.setValeur(Double.valueOf(request.getParameter(element.getNom())));
            c.setIdUser(user.getId());
           chiffres.add(c);

            // code pour traiter l'élément
        }
        for (CritereLettre element : v1) {
            InfoLettre c=new InfoLettre();
            c.setIdValeurCritere(Integer.valueOf(request.getParameter(element.getNom())));
            c.setIdUser(user.getId());
            lettres.add(c);

            // code pour traiter l'élément
        }
        infoChiffreService.saveAll(chiffres);
        infoLettreService.saveAll(lettres);
        m.addAttribute("user",user);
        return "recherche";
    }

    @RequestMapping(value = "/getrechercher")
    public String getrechercher(Model m,HttpServletRequest request){
        User user=userService.findById(Integer.valueOf(request.getParameter("user")));
        Iterable<CritereChiffre> v=  critereChiffreService.findAll();
        List<CritereLettre> v1=critereLettreService.getAll();

        List<RechercherChiffre> chiffres=new ArrayList<>();
        List<RechercherLettre> lettres=new ArrayList<>();

        for (CritereChiffre element : v) {
            RechercherChiffre c=new RechercherChiffre();
            c.setIdCritereChiffre(element.getId());
            c.setCoefficient(Integer.valueOf(request.getParameter(element.getNom()+"coeff")));
            c.setMin(Double.valueOf(request.getParameter(element.getNom()+"min")));
            c.setMax(Double.valueOf(request.getParameter(element.getNom()+"max")));
            c.setIdUser(user.getId());
            chiffres.add(c);

            // code pour traiter l'élément
        }
        for (CritereLettre element : v1) {
            RechercherLettre c=new RechercherLettre();
            c.setIdValeurCritere(Integer.valueOf(request.getParameter(element.getNom())));
            c.setCoefficient(Integer.valueOf(request.getParameter(element.getNom()+"coeff")));
            c.setIdUser(user.getId());
            lettres.add(c);

            // code pour traiter l'élément
        }
        rechercherChiffreService.saveAll(chiffres);
        rechercherLettreService.saveAll(lettres);
        List<User> all=fonctionService.compatible(user);
        m.addAttribute("liste",all);
       return "mate";
    }
    @RequestMapping(value = "/listeutilisateur")
    public String listeUtilisateur(Model m){

       m.addAttribute("liste",userService.allUser());
       User user1=new User("Jean","Jean",0,14.0);
       User user2=new User("Jeanne","Jeanne",1,14.0);
       User user3=new User("Julie","Julie",1,14.0);
       //userService.save(user1);
       //userService.save(user2);
       //userService.save(user3);
        return "listeUtilisateur";
    }

    @RequestMapping(value = "/getmate/{id}")
    public String getmate(@PathVariable("id") Integer id,Model m){
        User one=userService.findById(id);
        List<User> all=fonctionService.compatible(one);
        m.addAttribute("liste",all);
        return "mate";
    }

    @RequestMapping(value = "/infomate/{id}")
    public String infoMate(@PathVariable("id") Integer id,Model m){
        User one=userService.findById(id);
        m.addAttribute("chiffre",userService.getChiffre(id));
        m.addAttribute("Lettre",userService.getLettre(id));
        return "infoMate";
    }
}
