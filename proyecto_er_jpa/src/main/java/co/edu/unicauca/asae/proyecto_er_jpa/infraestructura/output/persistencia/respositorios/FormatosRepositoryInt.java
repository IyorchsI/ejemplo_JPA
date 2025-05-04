package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;

public interface FormatosRepositoryInt extends CrudRepository<FormatoAEntity, Integer> {

    @Query(value = "SELECT COUNT(*) FROM formatosA WHERE titulo_formato = ?1", nativeQuery = true)
    Integer existeFormatoAConTitulo(String titulo);
    
    @Query("SELECT f FROM FormatoAEntity f JOIN FETCH f.objDocente WHERE f.id_formato = :id_formato")
    List<FormatoAEntity> obtenerConDocentePorId(@Param("id_formato") Integer id_formato);

    @Query("SELECT f FROM FormatoAEntity f WHERE f.id_formato = :id_formato")
    Optional<FormatoAEntity> findFormatoAConRelacionesCompletas(@Param("id_formato") Integer id_formato);
}
