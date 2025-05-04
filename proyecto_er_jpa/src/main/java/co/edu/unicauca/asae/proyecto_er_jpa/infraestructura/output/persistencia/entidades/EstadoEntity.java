package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estados")
@Getter
@Setter
@AllArgsConstructor
public class EstadoEntity {
    @Id
    private Integer idFormatoA; // PK que también es FK

    @Column(nullable = false, length = 50)
    private String estado_actual;

    @Column(nullable = false)
    private Date fecha_registro_estado;

    @OneToOne
    @MapsId // Indica que el id se toma del FormatoA
    @JoinColumn(name = "idFormatoA")
    private FormatoAEntity objFormatoA;

    public EstadoEntity() {
        this.estado_actual = "En formulación";
    }
}
