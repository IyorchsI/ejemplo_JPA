package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarObservacionCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Observacion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionConsultaDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Observacion.ObservacionDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Observacion.ObservacionMapperInfraDominio;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
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

        // Ejecutar caso de uso
        Observacion observacionCreada = objGestionarObservacionCUInt.crearObservacion(observacionACrear,
                objObservacionPeticion.getIds_docentes(), objObservacionPeticion.getId_formato());

        // Mapear modelo de dominio a DTO respuesta
        ResponseEntity<ObservacionDTORespuesta> objRespuesta = new ResponseEntity<ObservacionDTORespuesta>(
                objMapeadorObservacion.mappearDeObservacionARespuesta(observacionCreada), HttpStatus.CREATED);

        // Retornar la respuesta
        return objRespuesta;
    }

    // Punto 3. LISTAR OBSERVACIONES COMPLETAS //
    @GetMapping("/observaciones/{id_formato}")
    public ResponseEntity<ObservacionConsultaDTORespuesta> listarObservacionesPorFormato(
            @Min(value = 1) @PathVariable Integer id_formato) {

        // Obtener el formato con evaluaciones y observaciones
        FormatoA formato = objGestionarObservacionCUInt.obtenerFormatoConObservacionesPorId(id_formato);

        // Mapear modelo de dominio a DTO respuesta
        ObservacionConsultaDTORespuesta dtoRespuesta = objMapeadorObservacion
                .mappearDeFormatoAConsultaRespuesta(formato);

        ResponseEntity<ObservacionConsultaDTORespuesta> objRespuesta = new ResponseEntity<>(dtoRespuesta,
                HttpStatus.OK);

        // Retornar la respuesta
        return objRespuesta;
    }
}
