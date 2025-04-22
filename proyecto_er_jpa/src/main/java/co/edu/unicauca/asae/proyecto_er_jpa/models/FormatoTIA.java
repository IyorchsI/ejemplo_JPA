package co.edu.unicauca.asae.proyecto_er_jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "formatostia")
@Getter
@Setter
@NoArgsConstructor
public class FormatoTIA extends FormatoA {
    @Column(nullable = true, length = 100)
    private String nombre_estudiante2;
    public FormatoTIA(String titulo_formato,String objetivo_general,String objetivos_especificos,String nombre_estudiante1, 
    Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente,String nombre_estudiante2){
        super(titulo_formato,objetivo_general,objetivo_general,nombre_estudiante1, objEstado, evaluaciones, objDocente);
        this.nombre_estudiante2=nombre_estudiante2;
    }
}
