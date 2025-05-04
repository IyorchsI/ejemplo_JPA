package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;

import java.util.List;


public interface DocentesRepositoryInt extends JpaRepository<DocenteEntity,Integer>{
    
    @Query(value = "SELECT COUNT(*) FROM docentes WHERE correo = ?1", nativeQuery = true)
    Integer existeDocenteConCorreo(String correo);

    @Query(value = "SELECT COUNT(*) FROM DocenteEntity ")
    Integer existenDocentes();

    @Query(value = "SELECT * FROM docentes d  WHERE nombre_grupo = LOWER(:nombre_grupo) ORDER BY d.apellidos_docente ASC", nativeQuery = true)
    List<DocenteEntity> buscarPorNombreGrupoOrdenadoPorApellido(@Param("nombre_grupo") String nombre_grupo);
}
