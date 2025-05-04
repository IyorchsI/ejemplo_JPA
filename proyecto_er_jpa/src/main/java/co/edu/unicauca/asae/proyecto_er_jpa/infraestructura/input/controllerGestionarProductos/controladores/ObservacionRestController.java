package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarObservacionCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Observacion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Observacion.ObservacionMapperInfraDominio;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ObservacionRestController {

    // Interface Caso de Uso
    private final GestionarObservacionCUIntPort objGestionarObservacionCUInt;

    // Mapper
    private final ObservacionMapperInfraDominio objMapeadorObservacion;

    // PUNTO 2. CREAR OBSERVACION //
    @PostMapping("/observaciones")
    public ResponseEntity<ObservacionDTORespuesta> createObservacion(
            @RequestBody @Valid ObservacionDTOPeticion objObservacionPeticion) {

        // Mapear DTO a modelo de dominio
        Observacion observacionACrear = objMapeadorObservacion.mappearDePeticionAObservacion(objObservacionPeticion);

        System.out.println("--Convirtio de Peticion a Modelo--");

        // Ejecutar caso de uso
        Observacion observacionCreada = objGestionarObservacionCUInt.crearObservacion(observacionACrear, objObservacionPeticion.getIds_docentes(), objObservacionPeticion.getId_formato());

        System.out.println("--Creo el Modelo--");

        // Mapear modelo de dominio a DTO respuesta
        ResponseEntity<ObservacionDTORespuesta> objRespuesta = new ResponseEntity<ObservacionDTORespuesta>(
            objMapeadorObservacion.mappearDeObservacionARespuesta(observacionCreada), HttpStatus.CREATED);

        System.out.println("--Envia la respuesta--");
        
        return objRespuesta;
    }

}
