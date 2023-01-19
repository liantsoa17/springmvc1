package com.example.demo.repository;

import com.example.demo.model.ValeurCritere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValeurCritereRepo extends JpaRepository<ValeurCritere, Integer> {
    public List<ValeurCritere> findByIdCritereLettre(Integer idCritereLettre);
}
