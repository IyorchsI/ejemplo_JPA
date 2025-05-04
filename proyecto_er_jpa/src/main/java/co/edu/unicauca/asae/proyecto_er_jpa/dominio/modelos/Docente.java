package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Docente {

    private Integer id_docente;

    private String nombres_docente;

    private String apellidos_docente;

    private String nombre_grupo;

    private String correo;

    private List<FormatoA> formatosA;
    
    private List<Historico> historicos;

    public Docente() {
        this.formatosA = new ArrayList<FormatoA>();
        this.historicos = new ArrayList<Historico>();
    }

}
