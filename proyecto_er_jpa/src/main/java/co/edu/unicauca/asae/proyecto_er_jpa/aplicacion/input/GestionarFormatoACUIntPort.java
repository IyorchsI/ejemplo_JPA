package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

public interface GestionarFormatoACUIntPort {
    
    public FormatoA crearFormatoA(FormatoA objFormatoA);

    public List<FormatoA> consultarFormatosAPorDocente(Integer id_docente);

}
