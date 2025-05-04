package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Docente;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.MiembroComiteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraDominio {

    @Mapping(target = "id_docente", source = "objDocente.id_docente")
    @Mapping(target = "nombres_docente", source = "objDocente.nombres_docente")
    @Mapping(target = "apellidos_docente", source = "objDocente.apellidos_docente")
    @Mapping(target = "rol", source = "objRol.rol_asignado")
    MiembroComiteDTORespuesta mappearHistoricoAMiembroComite(Historico historico);

    List<MiembroComiteDTORespuesta> mappearMiembrosComite(List<Historico> historicos);
}
