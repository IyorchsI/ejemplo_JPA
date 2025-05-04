package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Observacion;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.DocenteDTOResumen;

@Mapper(componentModel = "spring")
public interface DocenteResumenMapper {
    DocenteDTOResumen toDTOResumen(Docente docente);
}
