package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {

    //Rest API

    //Docentes solicitados

    List<Docente> obtenerDocentesSolicitados(String nombre_grupo);
}
