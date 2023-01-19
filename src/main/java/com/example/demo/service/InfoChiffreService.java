package com.example.demo.service;

import com.example.demo.model.InfoChiffre;
import com.example.demo.repository.InfoChiffreRepo;
import org.springframework.stereotype.Service;

@Service
public class InfoChiffreService extends CrudService<InfoChiffre, InfoChiffreRepo>{
    public InfoChiffreService(InfoChiffreRepo repo) {
        super(repo);
    }
}
