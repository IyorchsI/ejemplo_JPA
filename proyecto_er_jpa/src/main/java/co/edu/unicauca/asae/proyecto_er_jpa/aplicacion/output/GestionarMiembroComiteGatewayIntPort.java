package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;

public interface GestionarMiembroComiteGatewayIntPort {
    
    public List<Docente> listar();

}
