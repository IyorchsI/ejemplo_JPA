package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;

public interface GestionarFormatoACUIntPort {
    
    // Servicios REST solicitados //

    // 1. Crear formato A

    // Tipo PP
    public FormatoPPA crearFormatoPPA(FormatoPPA  objFormatoPPA, Integer id_docente);

    // Tipo TI
    public FormatoTIA crearFormatoTIA(FormatoTIA objFormatoTIA, Integer id_docente);


    public List<FormatoA> buscarFormatoAporDocente(Integer id_docente);



}
