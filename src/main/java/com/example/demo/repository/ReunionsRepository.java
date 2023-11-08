package com.example.demo.repository;

import com.example.demo.model.Reunions;
import com.example.demo.model.Salles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReunionsRepository extends JpaRepository<Reunions,Integer> {

}
