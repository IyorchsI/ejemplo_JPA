package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

//import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

public interface GestionarFormatoACUIntPort {
    
    //Servicios REST solicitados//

    //1. Crear formato A.
    public FormatoA crearFormatoA(FormatoA objFormatoA);

    //5. Consultar formatos A por docente.
    //public List<FormatoA> consultarFormatosAPorDocente(Integer id_docente);

}
