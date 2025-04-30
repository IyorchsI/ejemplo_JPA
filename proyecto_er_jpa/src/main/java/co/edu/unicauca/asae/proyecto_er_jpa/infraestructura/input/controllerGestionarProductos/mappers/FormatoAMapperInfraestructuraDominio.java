package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers;

import java.util.List;
import org.mapstruct.Mapper;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.FormatoADTORespuesta;

@Mapper(componentModel = "spring")
public interface FormatoAMapperInfraestructuraDominio {

    FormatoA mappearDePeticionAFormatoA(FormatoADTOPeticion peticion);

    FormatoADTORespuesta mappearDeFormatoAARespuesta(FormatoA objFormatoA);

    List<FormatoADTORespuesta> mappearDeFormatosAARespuesta(List<FormatoA> formatosA);

}