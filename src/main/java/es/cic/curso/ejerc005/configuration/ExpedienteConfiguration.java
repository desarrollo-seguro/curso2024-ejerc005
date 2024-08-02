package es.cic.curso.ejerc005.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import es.cic.curso.ejerc005.service.ExpedienteService;

@Configuration
@PropertySource("classpath:/los.properties")
public class ExpedienteConfiguration {
    @Value("${ejerc005.expediente.valor}")
    private long valor;

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    
}
