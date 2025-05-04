package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;

public interface GestionarDocenteGatewayIntPort {

    // Servicios REST solicitados//

    // 4. Listar miembros del comité
    public List<Historico> listarMiembrosComite();
}
