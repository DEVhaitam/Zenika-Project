package com.example.demo.controller;


import com.example.demo.enums.TypeReunion;
import com.example.demo.model.Salles;
import com.example.demo.service.APIservices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/salles")
public class APIController {

    private final APIservices apIservices;


    @GetMapping("/disponibles")
    List<Salles> sallesDisponibles(){
        return apIservices.sallesDisponibles();
    }

    @GetMapping("/nbrePersonnes/{nbrePersonnes}")
    List<Salles> sallesParNbrePersonnes(@PathVariable(value = "nbrePersonnes") int nbrePersonnes){
        return apIservices.sallesParNbrePersonnes(nbrePersonnes);
    }

    @GetMapping("/typeReunion/{reunion}")
    List<Salles> sallesParTypeReunion(@PathVariable(value = "reunion") TypeReunion reunion){
        return apIservices.sallesParTypeReunion(reunion);
    }

    @PutMapping("/reservation")
    void reserverSalle(@RequestParam(value = "nomSalle") String nomSalle){
        apIservices.reserverSalle(nomSalle);
    }

    @PutMapping("/liberation")
    void libererSalle(@RequestParam(value = "nomSalle") String nomSalle){
        apIservices.libererSalle(nomSalle);
    }


}
