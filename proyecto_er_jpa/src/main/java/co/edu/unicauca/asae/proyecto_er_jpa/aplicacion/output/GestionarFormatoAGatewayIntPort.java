package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;

public interface GestionarFormatoAGatewayIntPort {

    // Servicios REST solicitados//

    // 1. Crear formato A.
    // Verifica si ya existe un formato A con el mismo título
    boolean existeFormatoAConTitulo(String titulo);

    // Guarda el formato PPA
    FormatoPPA guardarFormatoPPA(FormatoPPA formatoPPA);

    // Guarda el formato TIA
    FormatoTIA guardarFormatoTIA(FormatoTIA formatoTIA);

    // Obtiene un docente por su ID
    Docente obtenerDocentePorId(Integer id_docente);

    // Verifica si ya esxiste un docente con el mismo correo
    public boolean existeDocentePorCorreo(String correo);

    // Obtener un formato por id
    FormatoA obtenerFormatoAConDocentePorId(Integer id_formato);

}
