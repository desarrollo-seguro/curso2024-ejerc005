package es.cic.curso.ejerc005;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saludo")
public class SaludoController {
    @Autowired
    private SaludosService saludosService;

    @PostMapping
    public long crear(@RequestBody Saludo saludo) {
        if (saludo.getId() != null) {
            
        }
        
        return 1l;
    }

    @GetMapping("/{id}")
    public Saludo leer(@PathVariable("id") long id) {
        Saludo saludo = new Saludo(id,  "dssdfsdf", false, "Hola");
        return saludo;
    }

    @GetMapping
    public List<Saludo> listar() {
        // TODO Cambiar esto pero ya
        List<Saludo> respuesta = new ArrayList<>();
        Saludo saludo = new Saludo(1l,  "dssdfsdf", false, "Hola");
        
        respuesta.add(saludo);

        return respuesta;
    }

    @PutMapping
    public void actualizar(@RequestBody Saludo saludo) {
        throw new UnsupportedOperationException("No implementado aún");
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable("id") long id) {
    }

}