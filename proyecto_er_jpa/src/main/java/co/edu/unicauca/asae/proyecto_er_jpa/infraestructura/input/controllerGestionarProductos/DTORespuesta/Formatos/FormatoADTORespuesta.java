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
public class FormatoADTORespuesta {

    private Integer id_formato;
    private String titulo_formato;
    private String objetivo_general;
    private String objetivos_especificos;
    private String nombre_estudiante1;
    private String codigo_estudiante1;
    private Date fecha_registro;
    private String estado_actual;
    private DocenteDTORespuesta objDocente;
    private List<EvaluacionDTORespuesta> evaluaciones;
}
