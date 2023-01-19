package com.example.demo.repository;

import com.example.demo.model.InfoLettre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoLettreRepo extends JpaRepository<InfoLettre, Integer> {
    public List<InfoLettre> findByIdUser(int id);
}
