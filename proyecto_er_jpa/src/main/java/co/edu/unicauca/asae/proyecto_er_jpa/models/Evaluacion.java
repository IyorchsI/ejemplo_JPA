package co.edu.unicauca.asae.proyecto_er_jpa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evaluaciones")
@Getter
@Setter
@AllArgsConstructor

public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvaluacion")
    private Integer id_evaluacion;

    @Column(nullable = false, length = 255)
    private String concepto;

    @Column(nullable = false)
    private Date fecha_registro_concepto;

    @Column(nullable = false, length = 100)
    private String nombre_coordinador;

    @ManyToOne
    @JoinColumn(name = "idfkFormatoA", nullable = false)
    private FormatoA objFormatoA;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objEvaluacion")
    private List<Observacion> observaciones;

    public Evaluacion() {
        this.observaciones = new ArrayList<Observacion>();
    }

}
