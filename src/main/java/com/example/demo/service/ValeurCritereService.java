package com.example.demo.service;

import com.example.demo.model.ValeurCritere;
import com.example.demo.repository.ValeurCritereRepo;
import org.springframework.stereotype.Service;

@Service
public class ValeurCritereService extends CrudService<ValeurCritere, ValeurCritereRepo>{
    public ValeurCritereService(ValeurCritereRepo repo) {
        super(repo);
    }
}
