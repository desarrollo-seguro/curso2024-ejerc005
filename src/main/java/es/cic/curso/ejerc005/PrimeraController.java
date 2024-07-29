package es.cic.curso.ejerc005;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/primera")
public class PrimeraController {
    @GetMapping("/{id}")
    public PrimeraDTO leer(@PathVariable("id") long id) {
        PrimeraDTO resultado = new PrimeraDTO();
        resultado.setNombre("Juan");
        
 
        SegundaDTO laOtra = new SegundaDTO();
        resultado.setSegundaDTO(laOtra);

        laOtra.setApellido("El mío");
        laOtra.setPrimeraDTO(resultado);
        
        return resultado;
    }
}
