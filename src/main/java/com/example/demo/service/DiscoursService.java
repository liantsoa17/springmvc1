package com.example.demo.service;

import com.example.demo.model.Discours;
import com.example.demo.repository.DiscoursRepo;
import org.springframework.stereotype.Service;

@Service
public class DiscoursService extends CrudService<Discours, DiscoursRepo>{
    public DiscoursService(DiscoursRepo repo) {
        super(repo);
    }
}
