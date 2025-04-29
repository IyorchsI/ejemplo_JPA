package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@AllArgsConstructor
public class Evaluacion {

    private Integer id_evaluacion;
    private String concepto;
    private Date fecha_registro_concepto;
    private String nombre_coordinador;
    private FormatoA objFormatoA;
    private List<Observacion> observaciones;

    public Evaluacion() {
        this.observaciones = new ArrayList<Observacion>();
    }
}
