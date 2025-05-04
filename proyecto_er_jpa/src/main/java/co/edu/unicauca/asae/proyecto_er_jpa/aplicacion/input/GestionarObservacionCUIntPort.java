package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public interface GestionarObservacionCUIntPort {
    
    // Servicios REST solicitados //

    // 2. Crear Observación
    public Observacion crearObservacion(Observacion objObservacion, List<@NotNull Integer> ids_docentes, Integer id_formato);
}
