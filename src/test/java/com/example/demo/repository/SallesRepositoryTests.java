package com.example.demo.repository;

import com.example.demo.model.Salles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class SallesRepositoryTests {

    @Autowired
    private SallesRepository sallesRepository;

    @BeforeAll
    void setUp(){
        Salles salle1 = Salles.builder()
                .nomsalle("E1001")
                .capacitemax(23)
                .capaciteeffective(16)
                .disponibilite(1)
                .NEANT(1)
                .ECRAN(0)
                .PIEUVRE(0)
                .TABLEAU(0)
                .WEBCAM(0)
                .build();

        Salles salle2 = Salles.builder()
                .nomsalle("E1002")
                .capacitemax(10)
                .capaciteeffective(7)
                .disponibilite(1)
                .NEANT(0)
                .ECRAN(0)
                .PIEUVRE(0)
                .TABLEAU(1)
                .WEBCAM(0)
                .build();

        Salles salle3 = Salles.builder()
                .nomsalle("E1003")
                .capacitemax(10)
                .capaciteeffective(7)
                .disponibilite(1)
                .NEANT(0)
                .ECRAN(1)
                .PIEUVRE(1)
                .TABLEAU(1)
                .WEBCAM(1)
                .build();

        Salles salle4 = Salles.builder()
                .nomsalle("E1004")
                .capacitemax(10)
                .capaciteeffective(7)
                .disponibilite(1)
                .NEANT(0)
                .ECRAN(1)
                .PIEUVRE(1)
                .TABLEAU(0)
                .WEBCAM(1)
                .build();
        sallesRepository.saveAndFlush(salle1);
        sallesRepository.saveAndFlush(salle2);
        sallesRepository.saveAndFlush(salle3);
        sallesRepository.saveAndFlush(salle4);
    }

    @Test
    //I took three just as an example
    public void capaciteEffectiveGreaterThanEqualThree(){
        List<Salles> salles = sallesRepository.findByCapaciteeffectiveGreaterThanEqual(3);
        assertTrue(2<=salles.size());
    }

    @Test
    public void sallePourRC(){
        List<Salles> salles = sallesRepository.findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(1,1,1,1);
        assertFalse(salles.isEmpty());
    }

    @Test
    public void sallePourRS(){
        //here I have used the remark mentioned in the SallesRepository Interface
        List<Salles> salles = sallesRepository.findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(0,0,0,0);
        assertFalse(salles.isEmpty());
    }

    @Test
    public void sallePourSPEC(){
        List<Salles> salles = sallesRepository.findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(0,0,0,1);
        assertFalse(salles.isEmpty());
    }

    @Test
    public void sallePourVC(){
        List<Salles> salles = sallesRepository.findByWEBCAMAndECRANAndPIEUVREAndTABLEAU(1,1,1,0);
        assertFalse(salles.isEmpty());
    }

    @Test
    public void sallesDispo(){
        List<Salles> salles = sallesRepository.findByDisponibilite(1);
        assertFalse(salles.isEmpty());
    }

    @Test
    public void sallesDsipoParCapaciteEffective(){
        int capEff = 5;
        List<Salles> salles = sallesRepository
                .findByDisponibiliteAndCapaciteeffectiveGreaterThanEqual(1,capEff);
        assertFalse(salles.isEmpty());
    }
}
