package es.cic.curso.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.ejerc005.model.Expediente;
import es.cic.curso.ejerc005.repository.ExpedienteRepository;

@Service
@Transactional
public class ExpedienteService {
    
    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Transactional(readOnly = true)
    public List<Expediente> listar() {
        return expedienteRepository.findAll();
    }

    public void actualizar(Expediente expediente) {
        expedienteRepository.save(expediente);
    }
    
}
