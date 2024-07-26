package es.cic.curso.ejerc005;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Saludo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max=10)
    private String dniCifNie;
    
    private boolean escuchado;

    private String mensaje;

    public Saludo() {

    }    

    public Saludo(Long id, String dniCifNie, boolean escuchado, String mensaje) {
        this.id = id;
        this.dniCifNie = dniCifNie;
        this.escuchado = escuchado;
        this.mensaje = mensaje;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDniCifNie() {
        return dniCifNie;
    }

    public void setDniCifNie(String dniCifNie) {
        this.dniCifNie = dniCifNie;
    }

    public boolean isEscuchado() {
        return escuchado;
    }

    public void setEscuchado(boolean escuchado) {
        this.escuchado = escuchado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
}
