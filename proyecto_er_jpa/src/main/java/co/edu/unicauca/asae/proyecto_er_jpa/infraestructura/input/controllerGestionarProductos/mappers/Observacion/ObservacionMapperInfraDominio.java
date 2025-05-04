package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Observacion;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Observacion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Evaluacion;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Evaluacion.EvaluacionDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionConsultaDTORespuesta;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Formatos.FormatoAMapperInfraestructuraDominio;

@Mapper(componentModel = "spring", uses = {DocenteResumenMapper.class, FormatoAMapperInfraestructuraDominio.class})
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

    // Evaluación a DTO incluyendo observaciones
    @Mapping(target = "observaciones", source = "observaciones")
    EvaluacionDTORespuesta mappearDeEvaluacionADTORespuesta(Evaluacion evaluacion);

    List<EvaluacionDTORespuesta> mappearDeEvaluacionesADTORespuesta(List<Evaluacion> evaluaciones);

    // Mapea la estructura completa requerida por el servicio de consulta
    @Mapping(target = "formato", source = "formato") // usa FormatoAMapperInternamente
    @Mapping(target = "evaluaciones", source = "formato.evaluaciones") // usa métodos locales
    ObservacionConsultaDTORespuesta mappearDeFormatoAConsultaRespuesta(FormatoA formato);
}
