package com.example.demo.repository;

import com.example.demo.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle,String> {
}
