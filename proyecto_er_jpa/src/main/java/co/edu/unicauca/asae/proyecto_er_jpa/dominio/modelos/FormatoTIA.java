package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormatoTIA extends FormatoA {

    private String nombre_estudiante2;

    public FormatoTIA(Integer id_formato, String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente,
            String nombre_estudiante2) {
        super(id_formato, titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, objEstado,
                evaluaciones, objDocente);
        this.nombre_estudiante2 = nombre_estudiante2;
    }
}
