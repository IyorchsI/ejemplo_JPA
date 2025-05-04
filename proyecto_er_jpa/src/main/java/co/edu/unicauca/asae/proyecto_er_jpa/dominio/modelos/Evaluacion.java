package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Evaluacion {

    private Integer id_evaluacion;

    private String concepto;

    private Date fecha_registro_concepto;

    private String nombre_coordinador;

}
