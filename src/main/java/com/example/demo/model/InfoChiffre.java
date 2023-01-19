package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "infochiffre")
public class InfoChiffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idcriterechiffre")
    private Integer idCritereChiffre;

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "valeur")
    private Double valeur;

   
}
