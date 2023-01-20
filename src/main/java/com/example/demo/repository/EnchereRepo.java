package com.example.demo.repository;

import com.example.demo.model.Enchere;


import org.springframework.data.jpa.repository.JpaRepository;

public interface EnchereRepo extends JpaRepository<Enchere,Integer> {
    // @Query(value = "select count(id) id,idcategorie,nom from enchere group by idcategorie,nom", nativeQuery = true)
    // List<Enchere> findStatistique();
}