package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Estado;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EstadoEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.EstadoRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.FormatosRepositoryInt;

@Service
public class GestionarFormatoAGatewayImplAdapter implements GestionarFormatoAGatewayIntPort {

    private final FormatosRepositoryInt formatoARepository;
    //private final DocentesRepositoryInt docenteRepository;
    private final EstadoRepositoryInt estadoRepository;
    private final ModelMapper formatoAModelMapper;

    public GestionarFormatoAGatewayImplAdapter(FormatosRepositoryInt formatoARepository, 
                                               DocentesRepositoryInt docenteRepository, 
                                               EstadoRepositoryInt estadoRepository, 
                                               ModelMapper formatoAModelMapper) {
        this.formatoARepository = formatoARepository;
        //this.docenteRepository = docenteRepository;
        this.estadoRepository = estadoRepository;
        this.formatoAModelMapper = formatoAModelMapper;
    }

    @Override
    public boolean existeFormatoAConTitulo(String titulo) {
        // Verifica si ya existe un formato A con el mismo título
        return formatoARepository.existeFormatoAConTitulo(titulo) > 0;
    }    

    @Override
    public FormatoA guardarFormatoA(FormatoA formatoA) {
        // Convierte el DTO a entidad y persiste el formato A
        FormatoAEntity formatoAEntity = formatoAModelMapper.map(formatoA, FormatoAEntity.class);
        
        // Guardamos el FormatoA y sus relaciones (Docente, Estado, etc.)
        FormatoAEntity formatoACreado = formatoARepository.save(formatoAEntity);

        // Mapea la entidad guardada a un objeto de dominio y lo devuelve
        return formatoAModelMapper.map(formatoACreado, FormatoA.class);
    }

    @Override
    public Docente obtenerDocentePorId(Integer id_docente) {
        /*  Recupera un docente de la base de datos por su ID
        return docenteRepository.findById(id_docente)
                .orElseThrow(() -> new DocenteNoEncontradoException("Docente no encontrado con id: " + idDocente));
        */
        return new Docente();
    }

    @Override
    public Estado guardarEstado(Estado estado) {
        // Mapea el Estado y lo guarda en la base de datos
        EstadoEntity estadoEntity = formatoAModelMapper.map(estado, EstadoEntity.class);
        EstadoEntity estadoGuardado = estadoRepository.save(estadoEntity);
        
        // Devuelve el estado guardado como un objeto de dominio
        return formatoAModelMapper.map(estadoGuardado, Estado.class);
    }
}

