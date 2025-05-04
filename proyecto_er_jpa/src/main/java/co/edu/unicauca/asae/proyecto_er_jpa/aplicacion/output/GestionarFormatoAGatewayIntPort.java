package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

//import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Estado;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

public interface GestionarFormatoAGatewayIntPort {

    //Servicios REST solicitados//

    //1. Crear formato A.
    // Verifica si ya existe un formato A con el mismo título
    boolean existeFormatoAConTitulo(FormatoA formatoA);
    
    // Guarda el formato A (incluyendo el estado y la relación con el docente)
    FormatoA guardarFormatoA(FormatoA formatoA);

    // Obtiene un docente por su ID
    Docente obtenerDocentePorId(Integer id_docente);
    
    // Guarda el estado de un formato A
    Estado guardarEstado(Estado estado);

    //5. Consultar formatos A por docente.
    //public List<FormatoA> consultarFormatosAPorDocente(Integer id_docente);

    //public Boolean existeFormatoAParaDocente(Integer id_docente);

}
