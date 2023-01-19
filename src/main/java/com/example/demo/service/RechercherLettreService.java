package com.example.demo.service;

import com.example.demo.model.RechercherLettre;
import com.example.demo.repository.RechercherLettreRepo;
import org.springframework.stereotype.Service;

@Service
public class RechercherLettreService extends CrudService<RechercherLettre, RechercherLettreRepo>{
    public RechercherLettreService(RechercherLettreRepo repo) {
        super(repo);
    }
}
