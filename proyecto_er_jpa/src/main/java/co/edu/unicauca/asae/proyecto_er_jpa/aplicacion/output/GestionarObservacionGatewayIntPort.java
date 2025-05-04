package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Evaluacion;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public interface GestionarObservacionGatewayIntPort {
    
    // Obtener la última evaluación asociada a un Formato A
    Integer obtenerUltimaEvaluacionPorFormatoA(Integer id_formato);

    // Obtener una evaluación por su ID
    Evaluacion obtenerEvaluacionPorId(Integer id_evaluacion);

    // Obtener una lista de docentes por sus IDs
    List<Docente> obtenerDocentesPorIds(List<Integer> ids_docentes);

    // Guardar una observación
    Observacion guardarObservacion(Observacion observacion);

    // Guardar una evaluación
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion);

    // Permite listas las observaciones por medio del id del Formato A
    FormatoA obtenerFormatoAConObservaciones(Integer id_formato);

}
