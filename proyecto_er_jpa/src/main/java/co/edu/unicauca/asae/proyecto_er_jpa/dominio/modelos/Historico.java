package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Historico {

    private Integer id_historico;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private Docente objDocente;
    private Rol objRol;

}
