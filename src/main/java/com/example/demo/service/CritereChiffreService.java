package com.example.demo.service;

import com.example.demo.model.CritereChiffre;
import com.example.demo.repository.CritereChiffreRepo;
import org.springframework.stereotype.Service;

@Service
public class CritereChiffreService extends CrudService<CritereChiffre, CritereChiffreRepo>{
    public CritereChiffreService(CritereChiffreRepo repo) {
        super(repo);
    }
}
