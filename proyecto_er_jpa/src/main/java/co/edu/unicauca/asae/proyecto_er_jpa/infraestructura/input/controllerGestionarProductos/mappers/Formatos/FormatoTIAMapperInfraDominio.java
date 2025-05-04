package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Formatos;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoTIADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos.FormatoTIADTORespuesta;

@Mapper(componentModel = "spring")
public interface FormatoTIAMapperInfraDominio {

    @Mapping(target = "id_formato", ignore = true)
    @Mapping(target = "objEstado", ignore = true)
    @Mapping(target = "objDocente", ignore = true)
    @Mapping(target = "evaluaciones", ignore = true)
    FormatoTIA mappearDePeticionAFormatoTIA(FormatoTIADTOPeticion peticion);

    @Mapping(target = "estado_actual", source = "objEstado.estado_actual")
    @Mapping(target = "nombres_docente", source = "objDocente.nombres_docente")
    FormatoTIADTORespuesta mappearDeFormatoTIARespuesta(FormatoTIA formatoTIA);

    List<FormatoTIADTORespuesta> mappearDeFormatosTIARespuesta(List<FormatoTIA> formatosTIA);

}
