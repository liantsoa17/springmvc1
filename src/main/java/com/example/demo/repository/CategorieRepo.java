package com.example.demo.repository;

import com.example.demo.model.Categorie;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie,Integer> {
    
}
