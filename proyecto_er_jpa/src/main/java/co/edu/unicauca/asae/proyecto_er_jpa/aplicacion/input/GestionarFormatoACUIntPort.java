package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;

public interface GestionarFormatoACUIntPort {

    public FormatoPPA crearFormatoPPA(FormatoPPA objFormatoPPA, Docente objDocente);

    public FormatoTIA crearFormatoTIA(FormatoTIA objFormatoTIA, Docente objDocente);

    public List<FormatoA> buscarFormatoAporDocente(Integer id_docente);

    public List<FormatoA> buscarFormatoADocentePorFecha(Integer id_docente, Date fechaInicio, Date fechaFin);

}
