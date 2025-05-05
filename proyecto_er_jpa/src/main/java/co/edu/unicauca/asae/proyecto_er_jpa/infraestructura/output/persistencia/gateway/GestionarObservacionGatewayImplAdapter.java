package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Evaluacion;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.EvaluacionesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.ObservacionesRepositoryInt;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.FormatosRepositoryInt;

@Service
@Transactional
public class GestionarObservacionGatewayImplAdapter implements GestionarObservacionGatewayIntPort {

    // Repositorios
    private final ObservacionesRepositoryInt observacionRepository;
    private final EvaluacionesRepositoryInt evaluacionRepository;
    private final DocentesRepositoryInt docenteRepository;
    private final FormatosRepositoryInt formatoARepository;

    // ModelMappers
    private final ModelMapper formatoAModelMapper;

    public GestionarObservacionGatewayImplAdapter(
            ObservacionesRepositoryInt observacionRepository,
            EvaluacionesRepositoryInt evaluacionRepository,
            DocentesRepositoryInt docenteRepository,
            FormatosRepositoryInt formatoARepository,
            ModelMapper formatoAModelMapper) {

        this.observacionRepository = observacionRepository;
        this.evaluacionRepository = evaluacionRepository;
        this.docenteRepository = docenteRepository;
        this.formatoARepository = formatoARepository;
        this.formatoAModelMapper = formatoAModelMapper;
    }

    @Override
    @Transactional
    public Observacion guardarObservacion(Observacion observacion) {
        ObservacionEntity entity = formatoAModelMapper.map(observacion, ObservacionEntity.class);
        ObservacionEntity guardada = observacionRepository.save(entity);
        return formatoAModelMapper.map(guardada, Observacion.class);
    }

    @Override
    @Transactional
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion) {
        try {
            EvaluacionEntity entity = formatoAModelMapper.map(evaluacion, EvaluacionEntity.class);
            entity.setFecha_registro_concepto(new Date());

            System.out.println("--INTENTA GUARDAR LA EVALUACION--");
            EvaluacionEntity saved = evaluacionRepository.save(entity);
            System.out.println("--CREO LA EVALUACION Y LA GUARDO--");

            return formatoAModelMapper.map(saved, Evaluacion.class);
        } catch (Exception e) {
            System.out.println("--ERROR AL GUARDAR EVALUACION--");
            e.printStackTrace(); // para que veas el detalle
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Integer obtenerUltimaEvaluacionPorFormatoA(Integer id_formato) {
        return evaluacionRepository.obtenerIdUltimaEvaluacionPorFormato(id_formato);
    }

    @Override
    @Transactional(readOnly = true)
    public Evaluacion obtenerEvaluacionPorId(Integer id_evaluacion) {
        EvaluacionEntity entity = evaluacionRepository.findById(id_evaluacion)
                .orElseThrow(() -> new RuntimeException("Evaluación no encontrada con ID: " + id_evaluacion));
        return formatoAModelMapper.map(entity, Evaluacion.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> obtenerDocentesPorIds(List<Integer> ids_docentes) {
        List<DocenteEntity> entidades = docenteRepository.findAllById(ids_docentes);
        return entidades.stream()
                .map(docente -> formatoAModelMapper.map(docente, Docente.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FormatoA obtenerFormatoAConObservaciones(Integer id_formato) {

        Optional<FormatoAEntity> formatoEntityOptional = this.formatoARepository
                .findFormatoAConRelacionesCompletas(id_formato);

        if (formatoEntityOptional.isEmpty()) {
            System.out.println("--NO SE ENCONTRO FORMATO A--");
            return null;
        }

        FormatoA formato = formatoAModelMapper.map(formatoEntityOptional.get(), FormatoA.class);

        return formato;
    }

}
