package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "infolettre")
public class InfoLettre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idvaleurcritere")
    private Integer idValeurCritere;

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "valeur")
    private String valeur;
}
