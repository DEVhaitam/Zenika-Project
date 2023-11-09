package com.example.demo.repository;

import com.example.demo.model.Salles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SallesRepository extends JpaRepository<Salles,String> {
       public List<Salles> findByCapaciteeffectiveGreaterThanEqual(Integer capacite);

       //the logic behind these functions was to use each one for its use case
       //as well as give 1 directly to the values we are looking for

       //A better approach for reducing the number of methods would be
       //just to use the findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(w,e,p,t) method
       //and switch between 1 and 0 depending on the use case
       //hence we'll have one method instead of three

       public List<Salles> findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(Integer w,Integer e, Integer p,Integer t);
       public List<Salles> findByECRANAndPIEUVREAndWEBCAM(Integer e,Integer p,Integer w);

       //I have used tableau and ecran just to select only
       //rooms with tableau (I could have other parameters)
       //the goal was to select only rooms that have tableaux
       //without any additional equipment
       public List<Salles> findByTABLEAUAndECRAN(Integer t, Integer e);
       public List<Salles> findByNEANTAndCapaciteeffectiveGreaterThanEqual(Integer n, Integer c);
       public List<Salles> findByDisponibilite(Integer i);
       public List<Salles> findByDisponibiliteAndCapaciteeffectiveGreaterThanEqual(Integer d,Integer c);
}
