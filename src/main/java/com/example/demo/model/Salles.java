package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table
public class Salles {
    @Id
    private String nomsalle;


    private Integer capacitemax;


    private Integer capaciteeffective;
    private Integer disponibilite;

    private Integer NEANT;
    private Integer ECRAN;
    private Integer PIEUVRE;
    private Integer TABLEAU;
    private Integer WEBCAM;

}
