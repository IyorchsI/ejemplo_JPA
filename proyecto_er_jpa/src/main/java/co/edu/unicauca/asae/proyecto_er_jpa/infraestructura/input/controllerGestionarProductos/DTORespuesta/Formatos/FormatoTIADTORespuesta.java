package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.DocenteDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Evaluacion.EvaluacionDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoTIADTORespuesta extends FormatoADTORespuesta {

    private String nombre_estudiante2;
    private String codigo_estudiante2;

    public FormatoTIADTORespuesta(Integer id_formato, String titulo_formato, String objetivo_general,
            String objetivos_especificos, String nombre_estudiante1, String codigo_estudiante1,
            Date fecha_registro, String estado_actual,
            DocenteDTORespuesta objDocente, List<EvaluacionDTORespuesta> evaluaciones, String nombre_estudiante2,
            String codigo_estudiante2) {

        super(id_formato, titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1,
                codigo_estudiante1,
                fecha_registro, estado_actual,
                objDocente, evaluaciones);
        this.nombre_estudiante2 = nombre_estudiante2;
        this.codigo_estudiante2 = codigo_estudiante2;

    }

}
