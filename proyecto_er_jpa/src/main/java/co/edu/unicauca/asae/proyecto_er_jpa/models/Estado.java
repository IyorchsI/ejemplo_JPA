package co.edu.unicauca.asae.proyecto_er_jpa.models;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="estados")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEstado")
    private Integer id_estado;
    @Column(nullable = false)
    private String estado_actual;
    @Column(nullable = false)
    private Date fecha_registro_estado;
    @OneToOne
    @JoinColumn(name = "idFKFormatoA", referencedColumnName = "idFormatoA")
    private FormatoA objFormatoA;
}
