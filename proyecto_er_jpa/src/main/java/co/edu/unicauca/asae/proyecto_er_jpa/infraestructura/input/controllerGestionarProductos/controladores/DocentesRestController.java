package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.controladores;


import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta.Docente.MiembroComiteDTORespuesta;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.mappers.Docente.DocenteMapperInfraDominio;


@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocentesRestController {

    // Interface Caso de Uso
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;

    // Mapper
    private final DocenteMapperInfraDominio objMapeadorDocente;

    // PUNTO 4. LISTAR MIEMBROS DEL COMITÉ //
    @GetMapping("/comite")
    public ResponseEntity<List<MiembroComiteDTORespuesta>> listarMiembrosComite() {
        List<Historico> historicos = objGestionarDocenteCUInt.listarMiembrosComite();
        List<MiembroComiteDTORespuesta> respuesta = objMapeadorDocente.mappearMiembrosComite(historicos);
        return ResponseEntity.ok(respuesta);
    }

}
