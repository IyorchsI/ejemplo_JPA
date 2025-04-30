package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;

//import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.FormatoADTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.FormatoAMapperInfraestructuraDominio;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FormatoARestController {

    private final GestionarFormatoACUIntPort objGestionarFormatoACUInt;
    private final FormatoAMapperInfraestructuraDominio objMapeadorFormatoA;

    @PostMapping("/formatos")
    public ResponseEntity<FormatoADTORespuesta> create(@RequestBody @Valid FormatoADTOPeticion objFormatoA) {
        FormatoA objFormatoACrear = objMapeadorFormatoA.mappearDePeticionAFormatoA(objFormatoA);
        FormatoA objFormatoACreado = objGestionarFormatoACUInt.crearFormatoA(objFormatoACrear);
        ResponseEntity<FormatoADTORespuesta> objRespuesta = new ResponseEntity<FormatoADTORespuesta>(
                objMapeadorFormatoA.mappearDeFormatoAARespuesta(objFormatoACreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    /* 
    @GetMapping("/por-docente/{idDocente}")
    public ResponseEntity<List<FormatoADTORespuesta>> consultarPorDocente(@PathVariable Integer idDocente) {
        List<FormatoA> formatos = objGestionarFormatoACUInt.consultarFormatosAPorDocente(idDocente);
        List<FormatoADTORespuesta> formatosRespuesta = objMapeadorFormatoA.mappearDeFormatosAARespuesta(formatos);
        ResponseEntity<List<FormatoADTORespuesta>> objRespuesta = new ResponseEntity<List<FormatoADTORespuesta>>(
                formatosRespuesta, HttpStatus.OK);
        return objRespuesta;
    }
    */
    
    /*Listar
    @GetMapping("/formatos")
    public ResponseEntity<List<FormatoADTORespuesta>> listar() {
        ResponseEntity<List<FormatoADTORespuesta>> objRespuesta = new ResponseEntity<List<FormatoADTORespuesta>>(
                objMapeadorFormatoA.mappearDeFormatoAARespuesta(this.objGestionarFormatoACUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
     */
}
