package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    private Integer id_rol;
    private String rol_asignado;

}
