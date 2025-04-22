package co.edu.unicauca.asae.proyecto_er_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_er_jpa.models.Docente;

public interface MiembrosRepository extends CrudRepository<Docente,Integer>{
    
}
