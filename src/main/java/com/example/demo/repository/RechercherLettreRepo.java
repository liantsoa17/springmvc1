package com.example.demo.repository;

import com.example.demo.model.RechercherLettre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechercherLettreRepo extends JpaRepository<RechercherLettre, Integer> {
    List<RechercherLettre> findByIdUser(int id);
}
