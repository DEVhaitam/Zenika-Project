package com.example.demo.repository;

import com.example.demo.model.Salles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salles,String> {
}
