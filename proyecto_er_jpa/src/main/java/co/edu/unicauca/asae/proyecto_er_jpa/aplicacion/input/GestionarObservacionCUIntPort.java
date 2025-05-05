package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public interface GestionarObservacionCUIntPort {

    public Observacion crearObservacion(Observacion objObservacion, List<@NotNull Integer> ids_docentes,
            Integer id_formato);

    FormatoA obtenerFormatoConObservacionesPorId(Integer id_formato);
}
