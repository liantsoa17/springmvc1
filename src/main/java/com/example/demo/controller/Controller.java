package com.example.demo.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.CustomException;
import com.example.demo.model.*;
import com.example.demo.repository.CommissionRepo;
import com.example.demo.service.*;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    UtilisateurService UtilisateurService;

    @Autowired
    AdminService AdminService;

    @Autowired
    EnchereService EnchereService;

    @Autowired
    CommissionRepo CommissionRepo;


    @GetMapping("/saveUtilisateur/{nom}&{prenom}&{date_naissance}&{email}&{mdp}")
    private void getKilometrage(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
            @PathVariable("date_naissance") String date_naissance, @PathVariable("email") String email,
            @PathVariable("mdp") String mdp) throws CustomException {
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setDate_naissance(Date.valueOf(date_naissance));
        user.setEmail(email);
        user.setMdp(mdp);
        UtilisateurService.create(user);
    }

    @GetMapping("/LoginAdmin/{email}&{mdp}")
    private Admin LoginAdmin(@PathVariable("email") String email, @PathVariable("mdp") String mdp) {
        Admin admin = AdminService.login(email, mdp);
        return admin;
    }

    @GetMapping("/AjoutEnchere/{nom}&{description}&{idcategorie}&{prix_minimal}&{duree}&{idutilisateur}")
    private void AjoutEnchere(@PathVariable("nom") String nom, @PathVariable("description") String description,
            @PathVariable("idcategorie") String idcategorie, @PathVariable("prix_minimal") String prix_minimal,
            @PathVariable("duree") String duree, @PathVariable("idutilisateur") String idutilisateur)
            throws CustomException {
        Enchere enchere = new Enchere();
        Commission commission = CommissionRepo.findCommission();
        enchere.setNom(nom);
        enchere.setDescription(description);
        enchere.setIdCategorie(Integer.parseInt(idcategorie));
        enchere.setPrix_minimal(Double.parseDouble(prix_minimal));
        enchere.setDuree(Double.parseDouble(duree));
        enchere.setIdUtilisateur(Integer.parseInt(idutilisateur));
        enchere.setIdStatus(1);
        enchere.setDate_enchere(Timestamp.valueOf(LocalDateTime.now()));
        enchere.setCommission((int) commission.getPourcentage());
        EnchereService.create(enchere);
    }

    @GetMapping("/Lister_enchere/{idutilisateur}")
    private List<V_listeEnchere_par_User> ListEnchere(@PathVariable("idutilisateur") String idutilisateur) throws Exception{
        List<V_listeEnchere_par_User> liste_enchere = EnchereService.findEncherebyId(idutilisateur);
        return  liste_enchere;
    }

}
