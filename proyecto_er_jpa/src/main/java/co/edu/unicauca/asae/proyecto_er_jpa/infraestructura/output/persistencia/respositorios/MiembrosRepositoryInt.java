package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.HistoricoEntity;

public interface MiembrosRepositoryInt extends CrudRepository<HistoricoEntity,Integer> {

    
}