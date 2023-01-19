package com.example.demo.repository;

import com.example.demo.model.RechercherChiffre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechercherChiffreRepo extends JpaRepository<RechercherChiffre, Integer> {
    public List<RechercherChiffre> findByIdUser(int id);
}
