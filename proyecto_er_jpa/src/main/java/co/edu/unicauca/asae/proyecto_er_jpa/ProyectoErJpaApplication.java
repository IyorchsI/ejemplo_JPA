package co.edu.unicauca.asae.proyecto_er_jpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.models.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.models.Estado;
import co.edu.unicauca.asae.proyecto_er_jpa.models.Evaluacion;
import co.edu.unicauca.asae.proyecto_er_jpa.models.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.models.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.models.FormatoTIA;
import co.edu.unicauca.asae.proyecto_er_jpa.models.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.models.Observacion;
import co.edu.unicauca.asae.proyecto_er_jpa.models.Rol;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.EvaluacionesRepository;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.FormatosRepository;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.MiembrosRepository;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.DocentesRepository;
import co.edu.unicauca.asae.proyecto_er_jpa.repositories.ObservacionesRepository;

@SpringBootApplication
@Transactional
public class ProyectoErJpaApplication implements CommandLineRunner {
	@Autowired
	private FormatosRepository servicioBDFormato;
	@Autowired
	private DocentesRepository servicioBDDocente;
	@Autowired
	private ObservacionesRepository servicioBDObservacion;
	@Autowired
	private EvaluacionesRepository servicioBDEvaluacion;
	@Autowired
	private MiembrosRepository servicioBDMiembro;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoErJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		almacenarFormatoPPA();
		almacenarObservacion();
		listarObservacion();
		listarMiembrosComite();
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

		List<Evaluacion> listaEvaluaciones = objFormatoA.getEvaluaciones();
		Evaluacion objEvaluacion = new Evaluacion();
		objEvaluacion.setConcepto(" ");
		objEvaluacion.setFecha_registro_concepto(new Date());
		objEvaluacion.setNombre_coordinador("Coordindador eva");
		objEvaluacion.setObjFormatoA(objFormatoA);

		listaEvaluaciones.add(objEvaluacion);
		
		objFormatoA.setEvaluaciones(listaEvaluaciones);
		
		Docente objDocente;
		if (this.servicioBDDocente.count() > 0) {
		objDocente = this.servicioBDDocente.getReferenceById(1);
		}else{
		objDocente = new Docente();
		objDocente.setApellidos_docente("Apellidos");
		objDocente.setCorreo("Correo");
		objDocente.setNombres_docente("Nombres");
		}
		objFormatoA.setObjDocente(objDocente);

		this.servicioBDFormato.save(objFormatoA);
		System.out.println("id almacenado: " + objFormatoA.getId_formato());
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

		List<Evaluacion> listaEvaluaciones = objFormatoA.getEvaluaciones();
		Evaluacion objEvaluacion = new Evaluacion();
		objEvaluacion.setConcepto(" ");
		objEvaluacion.setFecha_registro_concepto(new Date());
		objEvaluacion.setNombre_coordinador("Coordindador eva");
		objEvaluacion.setObjFormatoA(objFormatoA);

		listaEvaluaciones.add(objEvaluacion);
		
		objFormatoA.setEvaluaciones(listaEvaluaciones);

		Docente objDocente;
		if (this.servicioBDDocente.count() > 0) {
		objDocente = this.servicioBDDocente.getReferenceById(1);
		}else{
		objDocente = new Docente();
		objDocente.setApellidos_docente("Apellidos");
		objDocente.setCorreo("Correo");
		objDocente.setNombres_docente("Nombres");
		}
		objFormatoA.setObjDocente(objDocente);

		this.servicioBDFormato.save(objFormatoA);
		System.out.println("id almacenado: " + objFormatoA.getId_formato());
	}
	@Transactional
	public void almacenarObservacion(){
		Observacion objObservacion = new Observacion();
		objObservacion.setObservacion("Observacion noseque");
		objObservacion.setFecha_registro_observacion(new Date());

		Docente refenciaDocente = this.servicioBDDocente.getReferenceById(1);
		List<Docente> listaDocentes = objObservacion.getListaDocentes();

		listaDocentes.add(refenciaDocente);
		objObservacion.setListaDocentes(listaDocentes);

		Evaluacion referenciEvaluacion = this.servicioBDEvaluacion.getReferenceById(1);
		objObservacion.setObjEvaluacion(referenciEvaluacion);

		this.servicioBDObservacion.save(objObservacion);
		System.out.println("id almacenado: " + objObservacion.getId_observacion());
	}

	@Transactional(readOnly=true)
	public void listarObservacion(){
		Iterable<Observacion> listaObservaciones = this.servicioBDObservacion.findAll();
		for (Observacion observacion : listaObservaciones) {
			System.out.println("Observacion");
			System.out.println("Id: " + observacion.getId_observacion());
			System.out.println("Observacion: " + observacion.getObservacion());
			System.out.println("Fecha de registro: " + observacion.getFecha_registro_observacion());
			System.out.println("-------------------");
		
			Evaluacion evaluacion = observacion.getObjEvaluacion();
			System.out.println("evaluacion");
			System.out.println("Id: " + evaluacion.getId_evaluacion());
			System.out.println("evaluacion: " + evaluacion.getConcepto());
			System.out.println("evaluacion: " + evaluacion.getNombre_coordinador());
			System.out.println("-------------------");

			FormatoA formatoA = evaluacion.getObjFormatoA();
			System.out.println("Formato A");
			System.out.println("Id formato: "+formatoA.getId_formato());
			System.out.println("Estudiante 1: "+ formatoA.getNombre_estudiante1());
			System.out.println("Objetivo general: "+ formatoA.getObjetivo_general());
			System.out.println("Objetivos especificos: "+formatoA.getObjetivos_especificos());
			System.out.println("Titulo de formato: "+formatoA.getTitulo_formato());
			if(formatoA instanceof FormatoPPA){
				FormatoPPA formatoPPA = (FormatoPPA)formatoA;
				System.out.println("Nombre asesor: "+formatoPPA.getNombre_asesor());
				System.out.println("Ruta carta: "+formatoPPA.getRuta_carta_aceptacion());
			}else{
				FormatoTIA formatoTIA = (FormatoTIA)formatoA;
				System.out.println("Nombre estudiante 2: "+formatoTIA.getNombre_estudiante2());
			}
			System.out.println("-------------------");

			System.out.println("Docentes");
			Iterable<Docente> listaDocentes = observacion.getListaDocentes();;
			for (Docente docente : listaDocentes) {
				System.out.println("id: " + docente.getId_docente());
				System.out.println("Nombres: " + docente.getNombres_docente());
				System.out.println("Apellidos: " + docente.getApellidos_docente());
				System.out.println("Correo: " + docente.getCorreo());
				System.out.println("Grupo: " + docente.getNombre_grupo());
			}

			System.out.println(" ---- ---- ----");
		}
	}

	@Transactional(readOnly=true)
	public void listarMiembrosComite(){
		Iterable<Historico> listaHistoricos = this.servicioBDMiembro.findAll();
		for (Historico historico : listaHistoricos){
			System.out.println("Miembros de comite");
			System.out.println("Id: " + historico.getId_historico());
			System.out.println("activo: " + historico.getActivo());
			System.out.println("Fecha de inicio: " + historico.getFechaInicio());
			System.out.println("Fecha de fin: " + historico.getFechaFin());
			System.out.println("-------------------");
			Docente docente = historico.getObjDocente();
			System.out.println("Docente");
			System.out.println("id: " + docente.getId_docente());
			System.out.println("Nombres: " + docente.getNombres_docente());
			System.out.println("Apellidos: " + docente.getApellidos_docente());
			System.out.println("Correo: " + docente.getCorreo());
			System.out.println("Grupo: " + docente.getNombre_grupo());
			System.out.println("-------------------");
			Rol rol = historico.getObjRol();
			System.out.println("Rol");
			System.out.println("Rol asignado: "+rol.getRol_asignado());
			System.out.println("-------------------");
		}

	}

	@Transactional(readOnly=true)
	public void consultarFormatoADocente(){

	}

}
