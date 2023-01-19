package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "valeurcritere")
public class ValeurCritere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idcriterelettre")
    private Integer idCritereLettre;

    @Column(name = "valeur")
    private String valeur;


}
