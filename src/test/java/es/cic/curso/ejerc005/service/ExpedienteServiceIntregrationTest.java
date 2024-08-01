package es.cic.curso.ejerc005.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso.ejerc005.model.Expediente;
import es.cic.curso.ejerc005.Saludo;
import es.cic.curso.ejerc005.model.Documento;

import es.cic.curso.ejerc005.repository.ExpedienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@SpringBootTest
@AutoConfigureMockMvc
class ExpedienteServiceIntregrationTest {

	@Autowired
	private ExpedienteRepository expedienteRepository;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ExpedienteService expedienteService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	Expediente expediente;

	@BeforeEach
	public void setUp() {
		expediente = new Expediente();
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
	void testActualizarCambioNombreBorraDocumento() throws Exception {
		Expediente expedienteLeido = new Expediente();
		expedienteLeido.setId(expediente.getId());
		expedienteLeido.setNombre("Ninguno");

		expedienteService.actualizar(expedienteLeido);
	}

	@Test
	void testActualizarActualizarDocumento() throws Exception {
		Expediente expedienteLeido = new Expediente();
		expedienteLeido.setId(expediente.getId());
		expedienteLeido.setNombre("Ninguno");

		expedienteService.actualizar(expedienteLeido);
	}


	@Test
	void testLeer() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/api/expediente/{1}", expediente.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(expediente.getId()))
			.andReturn();

		String body = mvcResult.getResponse().getContentAsString();
		Expediente expedienteResultado = objectMapper.readValue(body, Expediente.class);

		assertTrue(expedienteResultado.getDocumentos().size() >= 1);
	}
}
