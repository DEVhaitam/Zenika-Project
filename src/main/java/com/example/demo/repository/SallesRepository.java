package com.example.demo.repository;

import com.example.demo.model.Salles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SallesRepository extends JpaRepository<Salles,String> {
       public List<Salles> findByCapaciteeffectiveGreaterThanEqual(Integer capacite);
       public List<Salles> findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(Integer w,Integer e, Integer p,Integer t);
       public List<Salles> findByECRANAndPIEUVREAndWEBCAM(Integer e,Integer p,Integer w);
       public List<Salles> findByTABLEAUAndECRAN(Integer t, Integer e);
       public List<Salles> findByNEANTAndCapaciteeffectiveGreaterThanEqual(Integer n, Integer c);
       public List<Salles> findByDisponibilite(Integer i);
       public List<Salles> findByDisponibiliteAndCapaciteeffectiveGreaterThanEqual(Integer d,Integer c);
}
