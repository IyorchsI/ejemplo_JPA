package co.edu.unicauca.asae.proyecto_er_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_er_jpa.models.Observacion;

public interface ObservacionesRepository extends CrudRepository<Observacion,Integer> {
    
}
