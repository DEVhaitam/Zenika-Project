package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Salles {
    @Id
    private String nom_salle;

    private Integer capaciteMax;
    private Integer capaciteEffective;
    private Integer disponibilite;

    private Integer NEANT;
    private Integer ECRAN;
    private Integer PIEUVRE;
    private Integer TABLEAU;
    private Integer WEBCAM;

}
