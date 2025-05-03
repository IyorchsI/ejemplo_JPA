package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "formatosppa")
@Getter
@Setter
@NoArgsConstructor
public class FormatoPPAEntity extends FormatoAEntity {
    @Column(nullable = false, length = 100)
    private String nombre_asesor;

    @Column(nullable = false, length = 255)
    private String ruta_carta_aceptacion;

    public FormatoPPAEntity(
            String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, EstadoEntity objEstado, List<EvaluacionEntity> evaluaciones, 
            DocenteEntity objDocente, String nombre_asesor, String ruta_carta_aceptacion) {

        super(titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1,
                objEstado, evaluaciones, objDocente);

        this.nombre_asesor = nombre_asesor;
        this.ruta_carta_aceptacion = ruta_carta_aceptacion;
    }
}
