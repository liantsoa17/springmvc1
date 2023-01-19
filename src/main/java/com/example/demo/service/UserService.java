package com.example.demo.service;

import com.example.demo.model.InfoChiffre;
import com.example.demo.model.InfoLettre;
import com.example.demo.model.User;
import com.example.demo.repository.InfoChiffreRepo;
import com.example.demo.repository.InfoLettreRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends CrudService<User, UserRepo>{
    private final InfoLettreRepo infoLettreRepo;
    private final InfoChiffreRepo infoChiffreRepo;

    private final FonctionService fonctionService;

    private final ValeurMotService valeurMotService;

    public UserService(UserRepo repo, InfoLettreRepo infoLettreRepo, InfoChiffreRepo infoChiffreRepo, FonctionService fonctionService, ValeurMotService valeurMotService) {
        super(repo);
        this.infoLettreRepo = infoLettreRepo;
        this.infoChiffreRepo = infoChiffreRepo;
        this.fonctionService = fonctionService;
        this.valeurMotService = valeurMotService;
    }
    public void save(User user){
        this.repo.save(user);
    }
    public List<User> allUser(){
        List<User> rep= repo.findAll();
        for(int i=0;i<rep.size();i++){
            rep.get(i).setPoint( fonctionService.nombreMot(rep.get(i).getDiscours(),valeurMotService.findValeur()));
        }
        return rep;
    }

    public List<InfoChiffre> getChiffre(int id){ return  infoChiffreRepo.findByIdUser(id); }
    public List<InfoLettre> getLettre(int id){ return infoLettreRepo.findByIdUser(id); }
}
