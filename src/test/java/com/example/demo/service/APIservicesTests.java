package com.example.demo.service;


import com.example.demo.enums.TypeReunion;
import com.example.demo.model.Salles;
import com.example.demo.repository.SallesRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class APIservicesTests {

    @Mock
    private SallesRepository sallesRepository;
    @InjectMocks
    private APIservices apIservices;

    @Test
    public void sallesParTroisPersonnes(){
        List salles = Mockito.mock(List.class);

        when(
        sallesRepository.findByCapaciteeffectiveGreaterThanEqual(3))
                .thenReturn(salles);

        assertFalse(apIservices.sallesParNbrePersonnes(3).isEmpty());
    }

    @Test
    public void sallePourRS(){
        List salles = Mockito.mock(List.class);
        when(
        sallesRepository.findByNEANTAndCapaciteeffectiveGreaterThanEqual(1,3))
                .thenReturn(salles);

        assertFalse(apIservices.sallesParTypeReunion(TypeReunion.RS).isEmpty());
    }
    //same process goes for other types of meetings



}
