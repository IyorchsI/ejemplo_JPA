package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

public interface GestionarFormatoAGatewayIntPort {

    public FormatoA guardar(FormatoA formatoA);

    public List<FormatoA> consultarFormatosAPorDocente(Integer id_docente);

    public Boolean existeFormatoAParaDocente(Integer id_docente);

}
