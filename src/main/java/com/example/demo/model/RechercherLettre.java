package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "rechercherlettre")
public class RechercherLettre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idvaleurcritere")
    private Integer idValeurCritere;

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "coefficient")
    private Integer coefficient;

}
