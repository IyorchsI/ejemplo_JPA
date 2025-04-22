package co.edu.unicauca.asae.proyecto_er_jpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_er_jpa.models.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.models.Estado;
import co.edu.unicauca.asae.proyecto_er_jpa.models.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.models.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.models.FormatoTIA;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.FormatosRepository;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.MiembrosRepository;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.ObservacionesRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class ProyectoErJpaApplication implements CommandLineRunner {
	@Autowired
	private FormatosRepository servicioBDFormato;
	@Autowired
	private MiembrosRepository servicioBDMiembro;
	@Autowired
	private ObservacionesRepository servicioBDObservacion;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoErJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		almacenarFormatoPPA();
		// almacenarSolicitudes();
		// consultarUsuariosSolicitudes();

	}

	@Transactional
	public void almacenarFormatoPPA() {
		FormatoPPA formatoPPA = new FormatoPPA();
		formatoPPA.setTitulo_formato("Titulo formato PPA");
		formatoPPA.setObjetivo_general("Objetivo PPA");
		formatoPPA.setObjetivos_especificos("Especifico PPA");
		formatoPPA.setNombre_asesor("Asesor");
		formatoPPA.setNombre_estudiante1("Estudiante1");
		formatoPPA.setRuta_carta_aceptacion("Ruta");

		FormatoA objFormatoA = formatoPPA;

		Estado objEstado = new Estado();
		objEstado.setFecha_registro_estado(new Date());

		objEstado.setObjFormatoA(objFormatoA);

		objFormatoA.setObjEstado(objEstado);

		if (this.servicioBDMiembro.count() > 0) {

		}
		Docente objDocente = new Docente();
		objDocente.setApellidos_docente("Apellidos");
		objDocente.setCorreo("Correo");
		objDocente.setNombres_docente("Nombres");

		objFormatoA.setObjDocente(objDocente);

		this.servicioBDFormato.save(objFormatoA);
	}

	@Transactional
	public void almacenarFormatoTIA() {
		FormatoTIA formatoTIA = new FormatoTIA();
		formatoTIA.setTitulo_formato("Titulo formato PPA");
		formatoTIA.setObjetivo_general("Objetivo PPA");
		formatoTIA.setObjetivos_especificos("Especifico PPA");
		formatoTIA.setNombre_estudiante1("Estudiante1");

		FormatoA objFormatoA = formatoTIA;

		Estado objEstado = new Estado();
		objEstado.setFecha_registro_estado(new Date());

		objEstado.setObjFormatoA(objFormatoA);

		objFormatoA.setObjEstado(objEstado);

		Docente objDocente = new Docente();
		objDocente.setApellidos_docente("Apellidos");
		objDocente.setCorreo("Correo");
		objDocente.setNombres_docente("Nombres");

		objFormatoA.setObjDocente(objDocente);

		this.servicioBDFormato.save(objFormatoA);
	}

}
