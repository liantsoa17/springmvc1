package com.example.demo.service;

import com.example.demo.model.ValeurMot;
import com.example.demo.repository.ValeurMotRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValeurMotService extends CrudService<ValeurMot, ValeurMotRepo>{
    public ValeurMotService(ValeurMotRepo repo) {
        super(repo);
    }
    public List<ValeurMot> findValeur(){
        return  repo.findAll();
    }
}
