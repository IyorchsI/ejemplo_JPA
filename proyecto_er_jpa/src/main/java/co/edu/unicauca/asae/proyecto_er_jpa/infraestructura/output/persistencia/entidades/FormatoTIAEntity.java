package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

import java.util.Date;
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
    @Column(nullable = true, length = 12)
    private String codigo_estudiante2;

    public FormatoTIAEntity(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, String codigo_estudiante1, Date fecha_registro,
            EstadoEntity objEstado, List<EvaluacionEntity> evaluaciones, DocenteEntity objDocente, String nombre_estudiante2,String codigo_estudiante2) {
        super(titulo_formato, objetivo_general, objetivo_general, nombre_estudiante1, codigo_estudiante1,  fecha_registro, objEstado, evaluaciones,
                objDocente);
        this.nombre_estudiante2 = nombre_estudiante2;
        this.codigo_estudiante2=codigo_estudiante2;
    }
}
