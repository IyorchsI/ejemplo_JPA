package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiembroComiteDTORespuesta {

    private Integer id_docente;
    private String nombres_docente;
    private String apellidos_docente;
    private String rol;
    private Date fechaInicio;
    private Date fechaFin;

}
