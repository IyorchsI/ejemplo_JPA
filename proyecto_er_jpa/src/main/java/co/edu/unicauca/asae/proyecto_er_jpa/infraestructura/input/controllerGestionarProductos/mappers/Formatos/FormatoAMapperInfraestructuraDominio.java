package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Formatos;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos.FormatoADTORespuesta;


@Mapper(componentModel = "spring")
public interface FormatoAMapperInfraestructuraDominio {

    @Mapping(target = "id_formato", ignore = true)
    @Mapping(target = "objEstado", ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoA mappearDePeticionAFormatoA(FormatoADTOPeticion peticion);

    @Mapping(target = "estado_actual", source = "objEstado.estado_actual")
    @Mapping(target = "objDocente", source = "objDocente")
    @Mapping(target = "evaluaciones", source = "evaluaciones")
    FormatoADTORespuesta mappearDeFormatoAARespuesta(FormatoA objFormatoA);

    List<FormatoADTORespuesta> mappearDeFormatosAARespuesta(List<FormatoA> formatosA);
    
    
}