package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoPPADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos.FormatoTIADTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Formatos.FormatoADTORespuesta;
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
        objPPAACrear.getObjDocente());

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
        objTIAACrear.getObjDocente());

        // Convertir Formato del dominio DTORespuesta al DTORespuesta
        ResponseEntity<FormatoTIADTORespuesta> objRespuesta = new ResponseEntity<FormatoTIADTORespuesta>(
                objMapeadorTIA.mappearDeFormatoTIARespuesta(objTIAcreado), HttpStatus.CREATED);

        // Retorna la respuesta
        return objRespuesta;
    }


      @GetMapping("/por-docente/{idDocente}")
      public ResponseEntity<List<FormatoADTORespuesta>>
      consultarPorDocente(@Min(value = 1) @PathVariable Integer idDocente) {
      List<FormatoA> formatos = objGestionarFormatoACUInt.buscarFormatoAporDocente(idDocente);
      List<FormatoADTORespuesta> formatosRespuesta = new ArrayList<FormatoADTORespuesta>();
      for (FormatoA formato : formatos){
        if(formato instanceof FormatoPPA){
                formatosRespuesta.add(objMapeadorPPA.mappearDeFormatoPPARespuesta(((FormatoPPA) formato)));
        }else{
                formatosRespuesta.add(objMapeadorTIA.mappearDeFormatoTIARespuesta(((FormatoTIA)formato)));
        }
      }
      ResponseEntity<List<FormatoADTORespuesta>> objRespuesta = new
      ResponseEntity<List<FormatoADTORespuesta>>(
      formatosRespuesta, HttpStatus.OK);
      return objRespuesta;
      }


      @GetMapping("/por-docente-fecha/")
      public ResponseEntity<List<FormatoADTORespuesta>>consultarPorFechaIdDocente(@RequestParam("idDocente") Integer idDocente, @RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
      @RequestParam("fin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin ) {
      List<FormatoA> formatos = objGestionarFormatoACUInt.buscarFormatoADocentePorFecha(idDocente, fechaInicio, fechaFin);
      List<FormatoADTORespuesta> formatosRespuesta = new ArrayList<FormatoADTORespuesta>();
      for (FormatoA formato : formatos){
        if(formato instanceof FormatoPPA){
                formatosRespuesta.add(objMapeadorPPA.mappearDeFormatoPPARespuesta(((FormatoPPA) formato)));
        }else{
                formatosRespuesta.add(objMapeadorTIA.mappearDeFormatoTIARespuesta(((FormatoTIA)formato)));
        }
      }
      ResponseEntity<List<FormatoADTORespuesta>> objRespuesta = new
      ResponseEntity<List<FormatoADTORespuesta>>(
      formatosRespuesta, HttpStatus.OK);
      return objRespuesta;
      }

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
