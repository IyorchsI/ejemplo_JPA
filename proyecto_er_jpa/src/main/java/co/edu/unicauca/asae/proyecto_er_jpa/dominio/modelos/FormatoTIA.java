package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FormatoTIA extends FormatoA {
    private String nombre_estudiante2;

    private Integer codigo_estudiante2;

    public FormatoTIA(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, Integer codigo_estudiante1,
            Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente, String nombre_estudiante2, Integer codigo_estudiante2) {
        super(titulo_formato, objetivo_general, objetivo_general, nombre_estudiante1, codigo_estudiante1, objEstado, evaluaciones,
                objDocente);
        this.nombre_estudiante2 = nombre_estudiante2;
        this.codigo_estudiante2=codigo_estudiante2;
    }
}
