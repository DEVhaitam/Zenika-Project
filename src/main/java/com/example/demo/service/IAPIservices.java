package com.example.demo.service;

import com.example.demo.enums.TypeReunion;
import com.example.demo.model.Salles;

import java.util.List;

public interface IAPIservices {

      public List<Salles> sallesParNbrePersonnes(int nbrePersonnes);
      public List<Salles> sallesParTypeReunion(TypeReunion reunion);
      public void reserverSalle(String nomSalle);
      public void libererSalle(String nomSalle);

      public List<Salles> sallesDisponibles();
}
