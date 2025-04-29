package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.Date;
import lombok.Data;

@Data
@AllArgsConstructor
public class Estado {

    private Integer id_estado;
    private String estado_actual;
    private Date fecha_registro_estado;
    private FormatoA objFormatoA;

    public Estado() {
        this.estado_actual = "En formulación";
    }
}
