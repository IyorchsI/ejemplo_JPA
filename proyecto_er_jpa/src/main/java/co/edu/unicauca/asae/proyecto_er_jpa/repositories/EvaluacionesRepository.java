package co.edu.unicauca.asae.proyecto_er_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_er_jpa.models.Evaluacion;

public interface EvaluacionesRepository extends JpaRepository<Evaluacion,Integer> {

    
}