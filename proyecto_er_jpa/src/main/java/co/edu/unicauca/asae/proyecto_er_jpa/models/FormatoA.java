package co.edu.unicauca.asae.proyecto_er_jpa.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class FormatoA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormatoA")
    private Integer id_formato;

    @Column(nullable = false, unique = true, length = 100)
    private String titulo_formato;

    @Column(nullable = false)
    private String objetivo_general;

    @Column(nullable = false)
    private String objetivos_especificos;
    
    @Column(nullable = false, length = 100)
    private String nombre_estudiante1;

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "objFormatoA")
    private Estado objEstado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objFormatoA")
    private List<Evaluacion> evaluaciones;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "idfkDocente", nullable = false)
    private Docente objDocente;

    public FormatoA() {
        this.evaluaciones = new ArrayList<Evaluacion>();
    }

    public FormatoA(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, Estado objEstado, List<Evaluacion> evaluaciones, Docente objDocente) {
        this.titulo_formato = titulo_formato;
        this.objetivo_general = objetivo_general;
        this.objetivos_especificos = objetivos_especificos;
        this.nombre_estudiante1 = nombre_estudiante1;

        this.objEstado = objEstado;
        this.evaluaciones = evaluaciones;
        this.objDocente = objDocente;
    }
}
