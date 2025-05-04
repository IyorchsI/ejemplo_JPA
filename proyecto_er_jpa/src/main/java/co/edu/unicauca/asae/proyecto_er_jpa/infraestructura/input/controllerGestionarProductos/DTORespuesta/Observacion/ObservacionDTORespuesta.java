package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionDTORespuesta {
    private Integer id_observacion;
    private String observacion;
    private Date fecha_registro_observacion;
    private Integer id_evaluacion;
    private List<DocenteDTOResumen> docentes;
}
