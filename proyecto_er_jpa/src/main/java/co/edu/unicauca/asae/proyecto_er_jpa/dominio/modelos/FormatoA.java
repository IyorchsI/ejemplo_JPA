package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormatoA {

    private Integer id_formato;
    private String titulo_formato;
    private String objetivo_general;
    private String objetivos_especificos;
    private String nombre_estudiante1;
    private Estado objEstado;
    private List<Evaluacion> evaluaciones;
    private Docente objDocente;

    public FormatoA() {
        this.evaluaciones = new ArrayList<Evaluacion>();
    }
}
