package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Docente.DocenteDTOPeticion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.DocenteDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.MiembroComiteDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Docente.DocenteMapperInfraDominio;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {
    // Interface Caso de Uso
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;

    // Mappers
    private final DocenteMapperInfraDominio objMapeadorDocente;

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listarDocentes( @RequestBody @Valid DocenteDTOPeticion objDocentePeticion) {
        List<Docente> docentes = objGestionarDocenteCUInt.obtenerDocentesSolicitados(objDocentePeticion.getNombre_grupo());     

        List<DocenteDTORespuesta> respuesta = objMapeadorDocente.mappearDeDocenteARespuesta(docentes);

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/comite")
    public ResponseEntity<List<MiembroComiteDTORespuesta>> listarMiembrosComite() {
        List<Historico> historicos = objGestionarDocenteCUInt.listarMiembrosComite();
        List<MiembroComiteDTORespuesta> respuesta = objMapeadorDocente.mappearMiembrosComite(historicos);
        return ResponseEntity.ok(respuesta);
    }
        
}
