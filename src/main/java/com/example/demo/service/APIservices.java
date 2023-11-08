package com.example.demo.service;

import com.example.demo.enums.TypeReunion;
import com.example.demo.model.Salles;
import com.example.demo.repository.ReunionsRepository;
import com.example.demo.repository.SallesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class APIservices implements IAPIservices{

    private final SallesRepository salleRepository;
    private final ReunionsRepository reunionsRepository;

    @Override
    public List<Salles> sallesParNbrePersonnes(int nbrePersonnes) {
        return salleRepository.findByCapaciteeffectiveGreaterThanEqual(nbrePersonnes);
    }

    /*
    RC : webcam + ecran + pieuvre + tableau
    RS : neant + cap>3
    SPEC : tableau
    VC : ecran + pieuvre + webcam
     */
    @Override
    public List<Salles> sallesParTypeReunion(TypeReunion reunion) {
        List<Salles> salles;
        switch (reunion){
            case RC -> salles =
                salleRepository.findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(1,1,1,1);
            case VC ->  salles =
                salleRepository.findByECRANAndPIEUVREAndWEBCAM(1,1,1);
            case RS -> salles =
                salleRepository.findByNEANTAndCapaciteeffectiveGreaterThanEqual(1,3);
            case SPEC -> salles =
                salleRepository.findByTABLEAUAndECRAN(1,0);
            default -> salles = new ArrayList<>();
        }
        return salles;
    }

    @Override
    public void reserverSalle(String nomSalle){
        Optional<Salles> salles = salleRepository.findById(nomSalle);
        Salles salle;
        if(salles.isPresent() && salles.get().getDisponibilite().equals(1)){
            salle = salles.get();
            salle.setDisponibilite(0);
            salleRepository.saveAndFlush(salle);
        }
    }

    @Override
    public void libererSalle(String nomSalle){
        Optional<Salles> salles = salleRepository.findById(nomSalle);
        Salles salle;
        if(salles.isPresent() && salles.get().getDisponibilite().equals(0)){
            salle = salles.get();
            salle.setDisponibilite(1);
            salleRepository.saveAndFlush(salle);
        }
    }

    @Override
    public List<Salles> sallesDisponibles() {
        return salleRepository.findByDisponibilite(1);
    }

    /*
    there are two approaches to write this method
    1st: create the personalized request in the SallesRepository interface
    2nd: reuse the result of the sallesParNbrePersonnes method
    */

    @Override
    public List<Salles> sallesDispoParNbrePersonnes(int nbrePersonnes){
        return salleRepository.findByDisponibiliteAndCapaciteeffectiveGreaterThanEqual(1,nbrePersonnes);
    }

    /*
    this time I have used the 2nd approach
    It's not the very optimum, but it's just for illustrative reasons
     */
    @Override
    public List<Salles> sallesDispoParTypeReunion(TypeReunion reunion){
        List<Salles> salles = sallesParTypeReunion(reunion);
        List<Salles> result = new ArrayList<>();
        for(Salles salle:salles){
            if(salle.getDisponibilite().equals(1)) result.add(salle);
        }
        return result;
    }
}
