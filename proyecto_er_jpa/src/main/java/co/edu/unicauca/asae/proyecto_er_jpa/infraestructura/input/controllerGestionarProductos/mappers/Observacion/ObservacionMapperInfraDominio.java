package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Observacion;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Observacion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionDTORespuesta;

@Mapper(componentModel = "spring", uses = {DocenteResumenMapper.class})
public interface ObservacionMapperInfraDominio {
    
    // Convierte un DTO de petición en una entidad de dominio, ignorando los campos establecidos desde la lógica
    @Mapping(target = "id_observacion", ignore = true)
    @Mapping(target = "objEvaluacion", ignore = true)
    @Mapping(target = "listaDocentes", ignore = true)
    @Mapping(target = "fecha_registro_observacion", ignore = true)
    Observacion mappearDePeticionAObservacion(ObservacionDTOPeticion peticion);

    // Convierte una entidad de dominio a un DTO de respuesta
    @Mapping(target = "id_evaluacion", source = "objEvaluacion.id_evaluacion")
    @Mapping(target = "docentes", source = "listaDocentes")
    ObservacionDTORespuesta mappearDeObservacionARespuesta(Observacion observacion);

    List<ObservacionDTORespuesta> mappearDeObservacionesARespuesta(List<Observacion> observaciones);
}
