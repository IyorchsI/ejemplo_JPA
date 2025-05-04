package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;

public interface GestionarDocenteCUIntPort {
    
    // Servicios REST solicitados //

    // 4. Listar miembros del comité
    List<Historico> listarMiembrosComite();
}
