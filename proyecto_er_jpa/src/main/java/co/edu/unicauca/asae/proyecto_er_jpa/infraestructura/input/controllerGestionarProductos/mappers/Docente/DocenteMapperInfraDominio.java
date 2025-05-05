package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Docente;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Docente.DocenteDTOFormatoPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.DocenteDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.MiembroComiteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraDominio {
    
    @Mapping(target = "id_docente", ignore = true)
    @Mapping(target = "nombres_docente", ignore = true)
    @Mapping(target = "apellidos_docente", ignore = true)
    @Mapping(target = "correo", ignore = true)
    @Mapping(target = "formatosA", ignore = true)
    @Mapping(target = "historicos", ignore = true)
    Docente mappearDePeticionADocente(DocenteDTORespuesta peticion);

    Docente mapearDePeticionFormatoDocente(DocenteDTOFormatoPeticion peticion);

    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mappearDeDocenteARespuesta(List<Docente> docente);

    @Mapping(target = "id_docente", source = "objDocente.id_docente")
    @Mapping(target = "nombres_docente", source = "objDocente.nombres_docente")
    @Mapping(target = "apellidos_docente", source = "objDocente.apellidos_docente")
    @Mapping(target = "rol", source = "objRol.rol_asignado")
    MiembroComiteDTORespuesta mappearHistoricoAMiembroComite(Historico historico);

    List<MiembroComiteDTORespuesta> mappearMiembrosComite(List<Historico> historicos);
}
