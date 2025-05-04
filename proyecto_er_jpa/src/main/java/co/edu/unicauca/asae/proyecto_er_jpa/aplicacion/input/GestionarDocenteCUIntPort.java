package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;


import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {

    //Rest API

    //Docentes solicitados

    List<Docente> obtenerDocentesSolicitados(String nombre_grupo);
    
    // Servicios REST solicitados //

    // 4. Listar miembros del comité
    List<Historico> listarMiembrosComite();
}
