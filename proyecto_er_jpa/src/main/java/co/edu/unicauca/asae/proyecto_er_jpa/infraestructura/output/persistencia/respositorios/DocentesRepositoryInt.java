package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocentesRepositoryInt extends JpaRepository<DocenteEntity,Integer>{
    
}
