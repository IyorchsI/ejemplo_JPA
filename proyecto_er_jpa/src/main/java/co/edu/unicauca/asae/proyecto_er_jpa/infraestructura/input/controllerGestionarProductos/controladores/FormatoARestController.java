package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoPPADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoTIADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos.FormatoPPADTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos.FormatoTIADTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Formatos.FormatoPPAMapperInfraDominio;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Formatos.FormatoTIAMapperInfraDominio;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class FormatoARestController {

    // Interface Caso de Uso
    private final GestionarFormatoACUIntPort objGestionarFormatoACUInt;

    // Mappers
    private final FormatoPPAMapperInfraDominio objMapeadorPPA;
    private final FormatoTIAMapperInfraDominio objMapeadorTIA;

    // PUNTO 1. CREAR FORMATOA //
    // Permite Crear un formato PPA
    @PostMapping("/formatos/ppa")
    public ResponseEntity<FormatoPPADTORespuesta> createPPA(
            @RequestBody @Valid FormatoPPADTOPeticion objFormatoPPAPeticion) {

        // Convertir El DTOPeticion al Formato del dominio
        FormatoPPA objPPAACrear = objMapeadorPPA.mappearDePeticionAFormatoPPA(objFormatoPPAPeticion);
        
        // Utiliza el Caso de Uso para crear el Formato y darle la persistencia
        FormatoPPA objPPAcreado = objGestionarFormatoACUInt.crearFormatoPPA(objPPAACrear,
                objFormatoPPAPeticion.getId_docente());

        // Convertir Formato del dominio DTORespuesta al DTORespuesta
        ResponseEntity<FormatoPPADTORespuesta> objRespuesta = new ResponseEntity<FormatoPPADTORespuesta>(
                objMapeadorPPA.mappearDeFormatoPPARespuesta(objPPAcreado), HttpStatus.CREATED);

        // Retorna la respuesta
        return objRespuesta;
    }

    // Permite Crear un formato TIA
    @PostMapping("/formatos/tia")
    public ResponseEntity<FormatoTIADTORespuesta> createTIA(
            @RequestBody @Valid FormatoTIADTOPeticion objFormatoTIAPeticion) {

        // Convertir El DTOPeticion al Formato del dominio
        FormatoTIA objTIAACrear = objMapeadorTIA.mappearDePeticionAFormatoTIA(objFormatoTIAPeticion);
        
        // Utiliza el Caso de Uso para crear el Formato y darle la persistencia
        FormatoTIA objTIAcreado = objGestionarFormatoACUInt.crearFormatoTIA(objTIAACrear,
                objFormatoTIAPeticion.getId_docente());

        // Convertir Formato del dominio DTORespuesta al DTORespuesta
        ResponseEntity<FormatoTIADTORespuesta> objRespuesta = new ResponseEntity<FormatoTIADTORespuesta>(
                objMapeadorTIA.mappearDeFormatoTIARespuesta(objTIAcreado), HttpStatus.CREATED);

        // Retorna la respuesta
        return objRespuesta;
    }

    /*
     * @GetMapping("/por-docente/{idDocente}")
     * public ResponseEntity<List<FormatoADTORespuesta>>
     * consultarPorDocente(@PathVariable Integer idDocente) {
     * List<FormatoA> formatos =
     * objGestionarFormatoACUInt.consultarFormatosAPorDocente(idDocente);
     * List<FormatoADTORespuesta> formatosRespuesta =
     * objMapeadorFormatoA.mappearDeFormatosAARespuesta(formatos);
     * ResponseEntity<List<FormatoADTORespuesta>> objRespuesta = new
     * ResponseEntity<List<FormatoADTORespuesta>>(
     * formatosRespuesta, HttpStatus.OK);
     * return objRespuesta;
     * }
     */

    /*
     * Listar
     * 
     * @GetMapping("/formatos")
     * public ResponseEntity<List<FormatoADTORespuesta>> listar() {
     * ResponseEntity<List<FormatoADTORespuesta>> objRespuesta = new
     * ResponseEntity<List<FormatoADTORespuesta>>(
     * objMapeadorFormatoA.mappearDeFormatoAARespuesta(this.
     * objGestionarFormatoACUInt.listar()),
     * HttpStatus.OK);
     * return objRespuesta;
     * }
     */
}
