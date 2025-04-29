package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public interface GestionarObservacionCUIntPort {
    
    public Observacion crearObservacion(Observacion observacion);

    public List<Observacion> listarObservaciones();
    
}
