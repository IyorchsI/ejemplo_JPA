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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "observaciones")
@Getter
@Setter
@AllArgsConstructor

public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idObservacion")
    private Integer id_observacion;

    @Column(nullable = false)
    private String observacion;

    @Column(nullable = false)
    private Date fecha_registro_observacion;

    @ManyToOne
    @JoinColumn(name = "idfkEvaluacion", nullable = false)
    private Evaluacion objEvaluacion;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "observacion_docente", joinColumns = @JoinColumn(name = "idObservacion"), inverseJoinColumns = @JoinColumn(name = "idDocente"))
    private List<Docente> listaDocentes;

    public Observacion() {
        this.listaDocentes = new ArrayList<Docente>();
    }
}
