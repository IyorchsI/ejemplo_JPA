package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.Date;
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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "formatosA")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class FormatoAEntity {
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

    @Column(nullable = false, length = 12)
    private String codigo_estudiante1;

    @Column(nullable = false)
    private Date fecha_registro;

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "objFormatoA")
    private EstadoEntity objEstado;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "objFormatoA")
    private List<EvaluacionEntity> evaluaciones;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "idfkDocente", nullable = false)
    private DocenteEntity objDocente;

    public FormatoAEntity() {
        this.evaluaciones = new ArrayList<EvaluacionEntity>();
    }

    public FormatoAEntity(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1,String codigo_estudiante1, Date fecha_registro, EstadoEntity objEstado, List<EvaluacionEntity> evaluaciones, DocenteEntity objDocente) {
        this.titulo_formato = titulo_formato;
        this.objetivo_general = objetivo_general;
        this.objetivos_especificos = objetivos_especificos;
        this.nombre_estudiante1 = nombre_estudiante1;
        this.objEstado = objEstado;
        this.evaluaciones = evaluaciones;
        this.objDocente = objDocente;
        this.codigo_estudiante1 = codigo_estudiante1;
        this.fecha_registro=fecha_registro;
    }
}
