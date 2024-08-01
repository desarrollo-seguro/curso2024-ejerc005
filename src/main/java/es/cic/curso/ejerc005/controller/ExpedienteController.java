package es.cic.curso.ejerc005.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso.ejerc005.model.Expediente;
import es.cic.curso.ejerc005.service.ExpedienteService;

@RestController
@RequestMapping("/api/expediente")
public class ExpedienteController {

    @Autowired
    private ExpedienteService expedienteService;

    @GetMapping("/{id}")
    public Expediente leer(@PathVariable("id") long id)  {
        return expedienteService.leer(id);
    }

}