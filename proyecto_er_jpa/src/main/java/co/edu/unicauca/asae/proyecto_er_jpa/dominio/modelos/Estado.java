package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_estado")
public class Estado {

    private Integer id_estado;
    private String estado_actual;
    private Date fecha_registro_estado;
    @JsonIgnore
    private FormatoA objFormatoA;

    public Estado() {
        this.estado_actual = "En formulación";
    }
}

