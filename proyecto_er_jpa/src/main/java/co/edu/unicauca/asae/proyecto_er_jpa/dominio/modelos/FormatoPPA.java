package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FormatoPPA extends FormatoA {

    private String nombre_asesor;
    
    private String ruta_carta_aceptacion;

    public FormatoPPA(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1,Integer codigo_estudiante1,
            Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente, String nombre_asesor,
            String ruta_carta_aceptacion) {
        super(titulo_formato, objetivo_general, objetivo_general, nombre_estudiante1,codigo_estudiante1, objEstado, evaluaciones,
                objDocente);
        this.nombre_asesor = nombre_asesor;
        this.ruta_carta_aceptacion = ruta_carta_aceptacion;
    }
}
