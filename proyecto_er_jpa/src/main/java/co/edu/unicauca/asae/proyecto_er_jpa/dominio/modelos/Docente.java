package co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_docente")
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
