package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.ObservacionEntity;

public interface ObservacionesRepositoryInt extends CrudRepository<ObservacionEntity,Integer> {
    
    @Query("SELECT o FROM ObservacionEntity o WHERE o.objEvaluacion.objFormatoA.id_formato = :idFormato")
    List<ObservacionEntity> listarPorFormatoA(@Param("idFormato") Integer idFormato);

}
