package co.edu.unicauca.asae.proyecto_er_jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "historicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorico")
    private Integer id_historico;
    @Column(nullable = true)
    private Boolean activo;
    @Column(nullable = true)
    private Date fechaInicio;
    @Column(nullable = false)
    private Date fechaFin;
    @ManyToOne
    @JoinColumn(name="idfkRol", nullable = false)
    private Rol objRol;
    @ManyToOne
    @JoinColumn(name="idfkDocente", nullable = false)
    private Docente objDocente;
    
}
