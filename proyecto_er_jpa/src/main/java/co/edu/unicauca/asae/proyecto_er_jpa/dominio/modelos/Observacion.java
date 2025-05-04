package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Observacion {

    private Integer id_observacion;

    private String observacion;

    private Date fecha_registro_observacion;

    private Evaluacion objEvaluacion;

    private List<Docente> listaDocentes;

    public Observacion() {
        this.listaDocentes = new ArrayList<Docente>();
    }
}
