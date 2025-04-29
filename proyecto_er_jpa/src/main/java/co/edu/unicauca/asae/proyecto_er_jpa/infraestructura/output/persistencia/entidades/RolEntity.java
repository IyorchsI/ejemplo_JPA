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
@Table(name = "Roles")
@Getter
@Setter
@AllArgsConstructor
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer id_rol;

    @Column(nullable = false, length = 100)
    private String rol_asignado;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objRol")
    private List<HistoricoEntity> historicos;

    public RolEntity() {
        this.historicos = new ArrayList<HistoricoEntity>();
    }
}
