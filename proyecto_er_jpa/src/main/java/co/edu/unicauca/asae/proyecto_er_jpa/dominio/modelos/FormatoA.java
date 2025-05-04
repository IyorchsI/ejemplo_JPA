package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FormatoA {

    private Integer id_formato;

    private String titulo_formato;

    private String objetivo_general;

    private String objetivos_especificos;
    
    private String nombre_estudiante1;

    private Integer codigo_estudiante1;

    private Estado objEstado;

    private List<Evaluacion> evaluaciones;

    private Docente objDocente;

    public FormatoA() {
        this.evaluaciones = new ArrayList<Evaluacion>();
    }

    public FormatoA(String titulo_formato, String objetivo_general, String objetivos_especificos,
        String nombre_estudiante1, Integer codigo_estudiante1, Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente) {
        this.titulo_formato = titulo_formato;
        this.objetivo_general = objetivo_general;
        this.objetivos_especificos = objetivos_especificos;
        this.nombre_estudiante1 = nombre_estudiante1;
        this.codigo_estudiante1=codigo_estudiante1;

        this.objEstado = objEstado;
        this.evaluaciones = evaluaciones;
        this.objDocente = objDocente;

    } 
}
