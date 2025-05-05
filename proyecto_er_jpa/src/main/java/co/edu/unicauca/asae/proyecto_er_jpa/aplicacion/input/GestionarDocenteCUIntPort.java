package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {

    List<Docente> obtenerDocentesSolicitados(String nombre_grupo);

    List<Historico> listarMiembrosComite();
}
