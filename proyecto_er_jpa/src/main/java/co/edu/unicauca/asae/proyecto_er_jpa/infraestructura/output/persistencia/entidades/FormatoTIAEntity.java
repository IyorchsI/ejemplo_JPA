package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

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
public class FormatoTIAEntity extends FormatoAEntity {
    @Column(nullable = true, length = 100)
    private String nombre_estudiante2;

    public FormatoTIAEntity(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1,
            EstadoEntity objEstado, List<EvaluacionEntity> evaluaciones, DocenteEntity objDocente, String nombre_estudiante2) {
        super(titulo_formato, objetivo_general, objetivo_general, nombre_estudiante1, objEstado, evaluaciones,
                objDocente);
        this.nombre_estudiante2 = nombre_estudiante2;
    }
}
