package es.cic.curso.ejerc005.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso.ejerc005.model.Expediente;
import es.cic.curso.ejerc005.model.Documento;

import es.cic.curso.ejerc005.repository.ExpedienteRepository;


@SpringBootTest
class ExpedienteServiceIntregrationTest {

	@Autowired
	private ExpedienteRepository expedienteRepository;


	@Autowired
	private ExpedienteService expedienteService;

	@BeforeEach
	public void setUp() {
		Expediente expediente = new Expediente();
		expediente = expedienteRepository.save(expediente);

		Documento documento = new Documento();
		documento.setDescripcion("Hola");
		documento.setExpediente(expediente);

		expediente.getDocumentos().add(documento);
		expedienteRepository.save(expediente);
		expedienteRepository.flush();
	}

	@AfterEach
	public void tearDown() {
		//entityManager.remove(saludo);
	}


	@Test
	void testListar() throws Exception {
		List<Expediente> res = expedienteService.listar();

		assertTrue(res.size() >= 1, "No existe al menos el registro que yo quería");
	}



	@Test
	void testActualizar() throws Exception {
	}
}
