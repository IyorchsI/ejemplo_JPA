package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_formato")
@Data
@AllArgsConstructor
public class FormatoA {

    private Integer id_formato;
    private String titulo_formato;
    private String objetivo_general;
    private String objetivos_especificos;
    private String nombre_estudiante1;
    private String codigo_estudiante1;
    private Date fecha_registro;
    private Estado objEstado;
    private Docente objDocente;
    private List<Evaluacion> evaluaciones;

    public FormatoA() {
        this.evaluaciones = new ArrayList<Evaluacion>();
    }

    public FormatoA(Integer id_formato, String titulo_formato, String objetivo_general, String objetivos_especificos,
                    String nombre_estudiante1,String codigo_estudiante1, Date fecha_registro, Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente) {
        this.id_formato = id_formato;
        this.titulo_formato = titulo_formato;
        this.objetivo_general = objetivo_general;
        this.objetivos_especificos = objetivos_especificos;
        this.nombre_estudiante1 = nombre_estudiante1;
        this.objEstado = objEstado;
        this.evaluaciones = evaluaciones;
        this.objDocente = objDocente;
        this.codigo_estudiante1=codigo_estudiante1;
        this.fecha_registro=fecha_registro;
    }
}
