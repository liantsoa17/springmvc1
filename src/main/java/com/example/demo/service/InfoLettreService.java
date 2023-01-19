package com.example.demo.service;

import com.example.demo.model.InfoLettre;
import com.example.demo.repository.InfoLettreRepo;
import org.springframework.stereotype.Service;

@Service
public class InfoLettreService extends CrudService<InfoLettre, InfoLettreRepo>{
    public InfoLettreService(InfoLettreRepo repo) {
        super(repo);
    }
}
