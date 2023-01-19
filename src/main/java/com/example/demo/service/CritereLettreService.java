package com.example.demo.service;

import com.example.demo.model.CritereLettre;
import com.example.demo.repository.CritereLettreRepo;
import com.example.demo.repository.ValeurCritereRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CritereLettreService extends CrudService<CritereLettre, CritereLettreRepo>{

    private final ValeurCritereRepo valeurCritereRepo;
    private final CritereLettreRepo critereLettreRepo;

    public CritereLettreService(CritereLettreRepo repo, ValeurCritereRepo valeurCritereRepo, CritereLettreRepo critereLettreRepo) {
        super(repo);
        this.valeurCritereRepo = valeurCritereRepo;
        this.critereLettreRepo = critereLettreRepo;
    }
    public List<CritereLettre> getAll(){
        List<CritereLettre> rep=critereLettreRepo.findAll();
        for(int i=0;i<rep.size();i++){
            rep.get(i).setValeurCriteres(valeurCritereRepo.findByIdCritereLettre(rep.get(i).getId()));
        }
        return rep;
    }
}
