package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {
    public User(){

    }

    public User(String nom, String prenom, Integer sexe, Double note) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.note = note;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "nom")
    private String nom ;

    @Column(name = "prenom")
    private String prenom;


    @Column(name = "sexe")
    private Integer sexe;


    @Column(name="note")
    private Double note;

    @Column(name = "discours")
    private  String discours;

    @Transient
    private  double point;

}
