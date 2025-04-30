package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado")
    private Integer id_estado;

    @Column(nullable = false, length = 50)
    private String estado_actual;

    @Column(nullable = false)
    private Date fecha_registro_estado;

    @OneToOne
    @JoinColumn(name = "idfkFormatoA", referencedColumnName = "idFormatoA", unique = true)
    private FormatoAEntity objFormatoA;

    public EstadoEntity() {
        this.estado_actual = "En formulación";
    }
}
