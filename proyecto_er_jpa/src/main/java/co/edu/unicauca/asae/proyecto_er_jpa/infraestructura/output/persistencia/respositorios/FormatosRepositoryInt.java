package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;

public interface FormatosRepositoryInt extends JpaRepository<FormatoAEntity, Long> {

    @Query(value = "SELECT COUNT(*) FROM formatosa WHERE titulo_formato = ?1", nativeQuery = true)
    Long existeFormatoAConTituloQuery(String titulo);
    
}
