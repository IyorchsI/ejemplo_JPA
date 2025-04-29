package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public interface GestionarObservacionGatewayIntPort {

    public Observacion guardar(Observacion observacion);

    public List<Observacion> listar();

}
