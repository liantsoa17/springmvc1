package com.example.demo.service;

import com.example.demo.model.RechercherChiffre;
import com.example.demo.model.RechercherLettre;
import com.example.demo.repository.RechercherChiffreRepo;
import org.springframework.stereotype.Service;

@Service
public class RechercherChiffreService extends CrudService<RechercherChiffre, RechercherChiffreRepo>{
    public RechercherChiffreService(RechercherChiffreRepo repo) {
        super(repo);
    }
}
