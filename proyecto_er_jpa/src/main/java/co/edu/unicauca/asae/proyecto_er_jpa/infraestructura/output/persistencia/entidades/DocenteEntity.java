package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "docentes")
@Getter
@Setter
@AllArgsConstructor

public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocente")
    private Integer id_docente;

    @Column(nullable = false, length = 100)
    private String nombres_docente;

    @Column(nullable = false, length = 100)
    private String apellidos_docente;

    @Column(nullable = true, length = 50)
    private String nombre_grupo;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<FormatoAEntity> formatosA;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objDocente")
    private List<HistoricoEntity> historicos;

    public DocenteEntity() {
        this.formatosA = new ArrayList<FormatoAEntity>();
        this.historicos = new ArrayList<HistoricoEntity>();
    }

}
