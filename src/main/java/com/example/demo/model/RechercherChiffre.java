package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "rechercherchiffre")
public class RechercherChiffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idcriterechiffre")
    private Integer idCritereChiffre;

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "coefficient")
    private Integer coefficient;

    @Column(name = "min")
    private double min;

    @Column(name = "max")
    private double max;



}
