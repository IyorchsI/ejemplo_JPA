package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Evaluacion;

import java.sql.Date;
import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionDTORespuesta {

    private Integer id_evaluacion;
    private String concepto;
    private Date fecha_registro_concepto;
    private List<ObservacionDTORespuesta> observaciones;
    
}
