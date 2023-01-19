package com.example.demo.repository;

import com.example.demo.model.InfoChiffre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoChiffreRepo extends JpaRepository<InfoChiffre, Integer> {
    public List<InfoChiffre> findByIdUser(int id);
}
