package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FormatoADTORespuesta {

    private Integer id_formato;
    private String titulo_formato;
    private String objetivo_general;
    private String objetivos_especificos;
    private String nombre_estudiante1;
    private Integer codigo_estudiante1;
    private String estado_actual;
    private String nombres_docente;
}
