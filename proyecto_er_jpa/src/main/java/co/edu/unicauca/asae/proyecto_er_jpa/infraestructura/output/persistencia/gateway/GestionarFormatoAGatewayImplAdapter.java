package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Estado;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoPPAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoTIAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.EstadoRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.FormatosRepositoryInt;


@Service
public class GestionarFormatoAGatewayImplAdapter implements GestionarFormatoAGatewayIntPort {

    private final FormatosRepositoryInt formatoARepository;
    private final DocentesRepositoryInt docenteRepository;
    private final EstadoRepositoryInt estadoRepository;
    private final ModelMapper formatoAModelMapper;

    public GestionarFormatoAGatewayImplAdapter(FormatosRepositoryInt formatoARepository, 
                                               DocentesRepositoryInt docenteRepository, 
                                               EstadoRepositoryInt estadoRepository, 
                                               ModelMapper formatoAModelMapper) {
        this.formatoARepository = formatoARepository;
        this.docenteRepository = docenteRepository;
        this.estadoRepository = estadoRepository;
        this.formatoAModelMapper = formatoAModelMapper;
    }

    // Método para verificar si existe un formato con el mismo titulo
    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoAConTitulo(FormatoA formatoA) { 
        boolean band=false;
        /*if(this.formatoARepository.existeFormatoAConTituloQuery(formatoA.getTitulo_formato()) > 0){
            band=true;
        }*/
        return band;
    }    

    // Método para guardar un Formato A
    @Override
    @Transactional
    public FormatoA guardarFormatoA(FormatoA formatoA) {

        FormatoAEntity formatoAEntity = null;
        if(formatoA instanceof FormatoPPA){
            FormatoPPAEntity formatoPPAEntity =formatoAModelMapper.map(formatoA, FormatoPPAEntity.class);
            formatoAEntity = formatoPPAEntity;
        }else{
            FormatoTIAEntity formatoTIAEntity =formatoAModelMapper.map(formatoA, FormatoTIAEntity.class);
            formatoAEntity = formatoTIAEntity;
        }

        EstadoEntity objEstado = new EstadoEntity();
        
        objEstado.setFecha_registro_estado(new Date());

        objEstado.setObjFormatoA(formatoAEntity);

        formatoAEntity.setObjEstado(objEstado);

        List<EvaluacionEntity> listaEvaluaciones = formatoAEntity.getEvaluaciones();
		EvaluacionEntity objEvaluacion = new EvaluacionEntity();
		objEvaluacion.setConcepto(" ");
		objEvaluacion.setFecha_registro_concepto(new Date());
		objEvaluacion.setNombre_coordinador("Coordindador eva");
		objEvaluacion.setObjFormatoA(formatoAEntity);

		listaEvaluaciones.add(objEvaluacion);
		
		formatoAEntity.setEvaluaciones(listaEvaluaciones);

        DocenteEntity objDocente;
		//if (this.docenteRepository.count() > 0) {
		//objDocente = this.docenteRepository.getReferenceById(1);
        /*}else{*/
		objDocente = new DocenteEntity();
		objDocente.setApellidos_docente("Apellidos");
		objDocente.setCorreo("Correo");
		objDocente.setNombres_docente("Nombres");
		//}
		formatoAEntity.setObjDocente(objDocente);

        // Guardamos el FormatoA y sus relaciones (Docente, Estado)
        FormatoAEntity formatoACreado = formatoARepository.save(formatoAEntity);

        // Mapea la entidad guardada a un objeto de dominio y lo devuelve
        return formatoAModelMapper.map(formatoACreado, FormatoA.class);
    }

    // Método para obtener un Docente por su id
    @Override
    @Transactional(readOnly = true)
    public Docente obtenerDocentePorId(Integer id_docente) {
        /*  Recupera un docente de la base de datos por su ID
        return docenteRepository.findById(id_docente)
                .orElseThrow(() -> new DocenteNoEncontradoException("Docente no encontrado con id: " + idDocente));
        */
        return new Docente();
    }

    // Método para guardar el estado
    @Override
    @Transactional
    public Estado guardarEstado(Estado estado) {
        // Mapea el Estado y lo guarda en la base de datos
        EstadoEntity estadoEntity = formatoAModelMapper.map(estado, EstadoEntity.class);
        EstadoEntity estadoGuardado = estadoRepository.save(estadoEntity);
        
        // Devuelve el estado guardado como un objeto de dominio
        return formatoAModelMapper.map(estadoGuardado, Estado.class);
    }
}

