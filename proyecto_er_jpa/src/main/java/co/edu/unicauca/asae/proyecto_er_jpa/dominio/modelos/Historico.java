package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historico {

    private Integer id_historico;

    private Boolean activo;

    private Date fechaInicio;

    private Date fechaFin;

    private Docente objDocente;

    private Rol objRol;

}
