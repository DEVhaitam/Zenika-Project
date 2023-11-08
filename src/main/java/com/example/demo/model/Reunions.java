package com.example.demo.model;

import com.example.demo.enums.TypeReunion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Reunions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer starthour;
    private Integer endhour;

    @Enumerated(EnumType.STRING)
    private TypeReunion typereunion;

    private Integer nbrepersonnes;

}
