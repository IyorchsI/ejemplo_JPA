package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EvaluacionEntity;

public interface EvaluacionesRepositoryInt extends JpaRepository<EvaluacionEntity,Integer> {

    @Query("SELECT e.id_evaluacion FROM EvaluacionEntity e WHERE e.objFormatoA.id_formato = :idFormato ORDER BY e.id_evaluacion DESC LIMIT 1")
    Integer obtenerIdUltimaEvaluacionPorFormato(@Param("idFormato") Integer idFormato);
    
}