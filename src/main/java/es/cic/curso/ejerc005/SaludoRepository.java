package es.cic.curso.ejerc005;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface SaludoRepository extends CrudRepository<Saludo, Long>, PagingAndSortingRepository<Saludo, Long> {

}
