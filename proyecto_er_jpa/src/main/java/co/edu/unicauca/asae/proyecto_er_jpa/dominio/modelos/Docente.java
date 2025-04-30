package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@AllArgsConstructor
public class Docente {

    private Integer id_docente;
    private String nombres_docente;
    private String apellidos_docente;
    private String nombre_grupo;
    private String correo;
    private List<FormatoA> formatosA;

    public Docente() {
        this.formatosA = new ArrayList<FormatoA>();
    }
}
