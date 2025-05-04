package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Docente;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraDominio {
    
    @Mapping(target = "id_docente", ignore = true)
    @Mapping(target = "nombres_docente", ignore = true)
    @Mapping(target = "apellidos_docente", ignore = true)
    @Mapping(target = "correo", ignore = true)
    @Mapping(target = "formatosA", ignore = true)
    @Mapping(target = "historicos", ignore = true)
    Docente mappearDePeticionADocente(DocenteDTORespuesta peticion);

    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mappearDeDocenteARespuesta(List<Docente> docente);
    
}
