package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.FormatoPPADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.FormatoPPADTORespuesta;

@Mapper(componentModel = "spring")
public interface FormatoPPAMapperInfraDominio {
    
    @Mapping(target = "id_formato", ignore = true)
    @Mapping(target = "objEstado", ignore = true)
    @Mapping(target = "objDocente", ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoPPA mappearDePeticionAFormatoPPA(FormatoPPADTOPeticion peticion);

    @Mapping(target = "estado_actual", source = "objEstado.estado_actual")
    @Mapping(target = "nombres_docente", source = "objDocente.nombres_docente")
    FormatoPPADTORespuesta mappearDeFormatoPPARespuesta(FormatoPPA formatoPPA);
    
    List<FormatoPPADTORespuesta> mappearDeFormatosPPARespuesta(List<FormatoPPA> formatosPPA);
}
