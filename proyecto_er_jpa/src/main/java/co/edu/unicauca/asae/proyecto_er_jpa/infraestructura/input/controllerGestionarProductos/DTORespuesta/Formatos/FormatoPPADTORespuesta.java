package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Evaluacion.EvaluacionDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoPPADTORespuesta extends FormatoADTORespuesta {

    private String nombre_asesor;
    private String ruta_carta_aceptacion;

    public FormatoPPADTORespuesta(Integer id_formato, String titulo_formato, String objetivo_general,
            String objetivos_especificos, String nombre_estudiante1, String codigo_estudiante1,
            Date fecha_registro, String estado_actual,
            String nombres_docente,List<EvaluacionDTORespuesta> evaluaciones , String nombre_asesor, String ruta_carta_aceptacion) {

        super(id_formato, titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, codigo_estudiante1,
        fecha_registro, estado_actual,
                nombres_docente, evaluaciones);
        this.nombre_asesor = nombre_asesor;
        this.ruta_carta_aceptacion = ruta_carta_aceptacion;
        
    }

}
