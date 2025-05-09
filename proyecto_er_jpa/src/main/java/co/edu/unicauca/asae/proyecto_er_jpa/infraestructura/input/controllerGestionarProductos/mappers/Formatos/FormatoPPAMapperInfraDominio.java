package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Formatos;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoPPADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos.FormatoPPADTORespuesta;

@Mapper(componentModel = "spring")
public interface FormatoPPAMapperInfraDominio {
    
    @Mapping(target = "id_formato", ignore = true)
    @Mapping(target = "objEstado", ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoPPA mappearDePeticionAFormatoPPA(FormatoPPADTOPeticion peticion);

    @Mapping(target = "estado_actual", source = "objEstado.estado_actual")
    @Mapping(target = "objDocente", source = "objDocente")
    @Mapping(target = "evaluaciones", source = "evaluaciones")
    FormatoPPADTORespuesta mappearDeFormatoPPARespuesta(FormatoPPA formatoPPA);
    
    List<FormatoPPADTORespuesta> mappearDeFormatosPPARespuesta(List<FormatoPPA> formatosPPA);
}
