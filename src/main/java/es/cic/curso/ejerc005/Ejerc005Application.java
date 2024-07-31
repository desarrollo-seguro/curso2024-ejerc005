package es.cic.curso.ejerc005;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.cic.curso.ejerc005.model.Expediente;
import es.cic.curso.ejerc005.repository.ExpedienteRepository;

@SpringBootApplication
public class Ejerc005Application  {

	public static void main(String[] args) {
		SpringApplication.run(Ejerc005Application.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ExpedienteRepository expedienteRepository) {
	// 	return args -> {

	// 		Expediente expediente = new Expediente(); 
	// 		expediente.setNombre("Juan");

	// 		expedienteRepository.save(expediente);

	// 	};
	// }

	

}
