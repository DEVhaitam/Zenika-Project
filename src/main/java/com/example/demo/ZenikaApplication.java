package com.example.demo;

import com.example.demo.enums.TypeReunion;
import com.example.demo.model.Salles;
import com.example.demo.service.APIservices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ZenikaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ZenikaApplication.class, args);
		APIservices apIservices = applicationContext.getBean(APIservices.class);
		//System.out.println(apIservices.salleParNbrePersonnes(3));
		//apIservices.reserverSalle("E3004");
		List<Salles> salles = apIservices.sallesDisponibles();
		for(Salles salle:salles) System.out.println(salle.getNomsalle());

	}

}
