package co.edu.unicauca.asae.proyecto_er_jpa.models;

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

public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDocente")
    private Integer id_docente;
    @Column(nullable = false, length = 100)
    private String nombres_docente;
    @Column(nullable = false, length = 100)
    private String apellidos_docente;
    @Column(nullable = true, length = 50)
    private String nombre_grupo;
    @Column(nullable = true, length = 100)
    private String correo;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<FormatoA> formatosA;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<Historico> historicos;

    public Docente (){
        this.formatosA=new ArrayList<FormatoA>();
        this.historicos=new ArrayList<Historico>();
    }

}
