package co.edu.unicauca.asae.proyecto_er_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_er_jpa.models.Docente;

public interface MiembrosRepository extends JpaRepository<Docente,Integer>{
    
}
