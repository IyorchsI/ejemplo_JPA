package co.edu.unicauca.asae.proyecto_er_jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoPPAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoTIAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.HistoricoEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.RolEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.EvaluacionesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.FormatosRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.MiembrosRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.ObservacionesRepositoryInt;

@SpringBootApplication
@Transactional
public class ProyectoErJpaApplication implements CommandLineRunner {
	@Autowired
	private FormatosRepositoryInt servicioBDFormato;
	@Autowired
	private DocentesRepositoryInt servicioBDDocente;
	@Autowired
	private ObservacionesRepositoryInt servicioBDObservacion;
	@Autowired
	private EvaluacionesRepositoryInt servicioBDEvaluacion;
	@Autowired
	private MiembrosRepositoryInt servicioBDMiembro;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoErJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		almacenarFormatoPPA();
		almacenarObservacion();
		listarObservacion();
		listarMiembrosComite();
		consultarFormatoADocente();
	}

	@Transactional
	public void almacenarFormatoPPA() {
		FormatoPPAEntity formatoPPA = new FormatoPPAEntity();
		formatoPPA.setTitulo_formato("Titulo formato PPA");
		formatoPPA.setObjetivo_general("Objetivo PPA");
		formatoPPA.setObjetivos_especificos("Especifico PPA");
		formatoPPA.setNombre_asesor("Asesor");
		formatoPPA.setNombre_estudiante1("Estudiante1");
		formatoPPA.setRuta_carta_aceptacion("Ruta");

		FormatoAEntity objFormatoA = formatoPPA;

		EstadoEntity objEstado = new EstadoEntity();
		objEstado.setFecha_registro_estado(new Date());

		objEstado.setObjFormatoA(objFormatoA);

		objFormatoA.setObjEstado(objEstado);

		List<EvaluacionEntity> listaEvaluaciones = objFormatoA.getEvaluaciones();
		EvaluacionEntity objEvaluacion = new EvaluacionEntity();
		objEvaluacion.setConcepto(" ");
		objEvaluacion.setFecha_registro_concepto(new Date());
		objEvaluacion.setNombre_coordinador("Coordindador eva");
		objEvaluacion.setObjFormatoA(objFormatoA);

		listaEvaluaciones.add(objEvaluacion);
		
		objFormatoA.setEvaluaciones(listaEvaluaciones);
		
		DocenteEntity objDocente;
		if (this.servicioBDDocente.count() > 0) {
		objDocente = this.servicioBDDocente.getReferenceById(1);
		}else{
		objDocente = new DocenteEntity();
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
		FormatoTIAEntity formatoTIA = new FormatoTIAEntity();
		formatoTIA.setTitulo_formato("Titulo formato PPA");
		formatoTIA.setObjetivo_general("Objetivo PPA");
		formatoTIA.setObjetivos_especificos("Especifico PPA");
		formatoTIA.setNombre_estudiante1("Estudiante1");

		FormatoAEntity objFormatoA = formatoTIA;

		EstadoEntity objEstado = new EstadoEntity();
		objEstado.setFecha_registro_estado(new Date());

		objEstado.setObjFormatoA(objFormatoA);

		objFormatoA.setObjEstado(objEstado);

		List<EvaluacionEntity> listaEvaluaciones = objFormatoA.getEvaluaciones();
		EvaluacionEntity objEvaluacion = new EvaluacionEntity();
		objEvaluacion.setConcepto(" ");
		objEvaluacion.setFecha_registro_concepto(new Date());
		objEvaluacion.setNombre_coordinador("Coordindador eva");
		objEvaluacion.setObjFormatoA(objFormatoA);

		listaEvaluaciones.add(objEvaluacion);
		
		objFormatoA.setEvaluaciones(listaEvaluaciones);

		DocenteEntity objDocente;
		if (this.servicioBDDocente.count() > 0) {
		objDocente = this.servicioBDDocente.getReferenceById(1);
		}else{
		objDocente = new DocenteEntity();
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
		ObservacionEntity objObservacion = new ObservacionEntity();
		objObservacion.setObservacion("Observacion noseque");
		objObservacion.setFecha_registro_observacion(new Date());

		DocenteEntity refenciaDocente = this.servicioBDDocente.getReferenceById(1);
		List<DocenteEntity> listaDocentes = objObservacion.getListaDocentes();

		listaDocentes.add(refenciaDocente);
		objObservacion.setListaDocentes(listaDocentes);

		EvaluacionEntity referenciEvaluacion = this.servicioBDEvaluacion.getReferenceById(1);
		referenciEvaluacion.getObservaciones().add(objObservacion);
		objObservacion.setObjEvaluacion(referenciEvaluacion);

		this.servicioBDObservacion.save(objObservacion);
		System.out.println("id almacenado: " + objObservacion.getId_observacion());
	}

	@Transactional(readOnly=true)
	public void listarObservacion(){
		Iterable<ObservacionEntity> listaObservaciones = this.servicioBDObservacion.findAll();
		for (ObservacionEntity observacion : listaObservaciones) {
			System.out.println("Observacion");
			System.out.println("Id: " + observacion.getId_observacion());
			System.out.println("Observacion: " + observacion.getObservacion());
			System.out.println("Fecha de registro: " + observacion.getFecha_registro_observacion());
			System.out.println("-------------------");
		
			EvaluacionEntity evaluacion = observacion.getObjEvaluacion();
			System.out.println("evaluacion");
			System.out.println("Id: " + evaluacion.getId_evaluacion());
			System.out.println("evaluacion: " + evaluacion.getConcepto());
			System.out.println("evaluacion: " + evaluacion.getNombre_coordinador());
			System.out.println("-------------------");

			FormatoAEntity formatoA = evaluacion.getObjFormatoA();
			System.out.println("Formato A");
			System.out.println("Id formato: "+formatoA.getId_formato());
			System.out.println("Estudiante 1: "+ formatoA.getNombre_estudiante1());
			System.out.println("Objetivo general: "+ formatoA.getObjetivo_general());
			System.out.println("Objetivos especificos: "+formatoA.getObjetivos_especificos());
			System.out.println("Titulo de formato: "+formatoA.getTitulo_formato());
			if(formatoA instanceof FormatoPPAEntity){
				FormatoPPAEntity formatoPPA = (FormatoPPAEntity)formatoA;
				System.out.println("Nombre asesor: "+formatoPPA.getNombre_asesor());
				System.out.println("Ruta carta: "+formatoPPA.getRuta_carta_aceptacion());
			}else{
				FormatoTIAEntity formatoTIA = (FormatoTIAEntity)formatoA;
				System.out.println("Nombre estudiante 2: "+formatoTIA.getNombre_estudiante2());
			}
			System.out.println("-------------------");

			System.out.println("Docentes");
			Iterable<DocenteEntity> listaDocentes = observacion.getListaDocentes();;
			for (DocenteEntity docente : listaDocentes) {
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
		Iterable<HistoricoEntity> listaHistoricos = this.servicioBDMiembro.findAll();
		for (HistoricoEntity historico : listaHistoricos){
			System.out.println("Miembros de comite");
			System.out.println("Id: " + historico.getId_historico());
			System.out.println("activo: " + historico.getActivo());
			System.out.println("Fecha de inicio: " + historico.getFechaInicio());
			System.out.println("Fecha de fin: " + historico.getFechaFin());
			System.out.println("-------------------");
			DocenteEntity docente = historico.getObjDocente();
			System.out.println("Docente");
			System.out.println("id: " + docente.getId_docente());
			System.out.println("Nombres: " + docente.getNombres_docente());
			System.out.println("Apellidos: " + docente.getApellidos_docente());
			System.out.println("Correo: " + docente.getCorreo());
			System.out.println("Grupo: " + docente.getNombre_grupo());
			System.out.println("-------------------");
			RolEntity rol = historico.getObjRol();
			System.out.println("Rol");
			System.out.println("Rol asignado: "+rol.getRol_asignado());
			System.out.println("-------------------");
		}

	}

	@Transactional(readOnly=true)
	public void consultarFormatoADocente(){
		Optional<DocenteEntity> optional = this.servicioBDDocente.findById(1);
		if (optional.isPresent()) {
			DocenteEntity objDocente = optional.get();
			System.out.println("Formatos A por docente");
			System.out.println("Docente");
			System.out.println("id: " + objDocente.getId_docente());
			System.out.println("Nombres: " + objDocente.getNombres_docente());
			System.out.println("Apellidos: " + objDocente.getApellidos_docente());
			System.out.println("Correo: " + objDocente.getCorreo());
			System.out.println("Grupo: " + objDocente.getNombre_grupo());
			System.out.println("-------------------");
			for (FormatoAEntity formatoA : objDocente.getFormatosA()) {
				System.out.println("Formato A");
				System.out.println("Id formato: "+formatoA.getId_formato());
				System.out.println("Estudiante 1: "+ formatoA.getNombre_estudiante1());
				System.out.println("Objetivo general: "+ formatoA.getObjetivo_general());
				System.out.println("Objetivos especificos: "+formatoA.getObjetivos_especificos());
				System.out.println("Titulo de formato: "+formatoA.getTitulo_formato());
					if(formatoA instanceof FormatoPPAEntity){
						FormatoPPAEntity formatoPPA = (FormatoPPAEntity)formatoA;
						System.out.println("Nombre asesor: "+formatoPPA.getNombre_asesor());
						System.out.println("Ruta carta: "+formatoPPA.getRuta_carta_aceptacion());
					}else{
						FormatoTIAEntity formatoTIA = (FormatoTIAEntity)formatoA;
						System.out.println("Nombre estudiante 2: "+formatoTIA.getNombre_estudiante2());
					}
				System.out.println("-------------------");
				for(EvaluacionEntity evaluacion : formatoA.getEvaluaciones()){
					System.out.println("evaluacion");
					System.out.println("Id: " + evaluacion.getId_evaluacion());
					System.out.println("evaluacion: " + evaluacion.getConcepto());
					System.out.println("evaluacion: " + evaluacion.getNombre_coordinador());
					System.out.println("-------------------");
					for(ObservacionEntity observacion: evaluacion.getObservaciones()){
						System.out.println("Observacion");
						System.out.println("Id: " + observacion.getId_observacion());
						System.out.println("Observacion: " + observacion.getObservacion());
						System.out.println("Fecha de registro: " + observacion.getFecha_registro_observacion());
						System.out.println("-------------------");
					}
					
				}
				
			}
		} else {
			System.out.println("docente no encontrado");
		}

	}

}
