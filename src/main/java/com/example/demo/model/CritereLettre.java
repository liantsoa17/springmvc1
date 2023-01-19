package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "criterelettre")
public class CritereLettre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "nom")
    private String nom ;

    @Column(name = "question")
    private String question;

    @OneToMany(mappedBy = "id")
    List<ValeurCritere> valeurCriteres;

}
