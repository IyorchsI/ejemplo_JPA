package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rol {

    private Integer id_rol;

    private String rol_asignado;

    private List<Historico> historicos;

    public Rol() {
        this.historicos = new ArrayList<Historico>();
    }
    
}
