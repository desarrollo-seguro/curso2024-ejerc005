package es.cic.curso.ejerc005;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
 @Transactional
public class SaludoService {
    @Autowired
    private SaludoRepository saludoRepository;

    public long crear(Saludo saludo) {
        // try {
        //     if (Math.random() < 0.5) {
        //         throw new Exception();
        //     }
        // } catch (Exception e) {
        // throw new SaludosException("Algo ha ido mal", e);
        // }
        saludo = saludoRepository.save(saludo);
        return saludo.getId();
    }

    @Transactional(readOnly = true)
    public List<Saludo> listar() {
        Iterable<Saludo> parcial = saludoRepository.findAll();
        
        List<Saludo> result = new ArrayList<>();
        parcial.forEach(result::add);

        return (result) ;
    }

    @Transactional(readOnly = true) 
    public Saludo leer(long id) {
        Optional<Saludo> posibleResultado = saludoRepository.findById(id);

        return posibleResultado.orElse(null);       
    }

    public void actualizar(Saludo saludo) {
        saludoRepository.save(saludo);
    }

    public void borrar(long id) {
        saludoRepository.deleteById(id);
    }

}
