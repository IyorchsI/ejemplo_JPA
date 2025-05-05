package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoPPAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.FormatoTIAEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.EstadoRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.FormatosRepositoryInt;

@Service
@Transactional
public class GestionarFormatoAGatewayImplAdapter implements GestionarFormatoAGatewayIntPort {

    // Repositorios
    private final FormatosRepositoryInt formatoARepository;
    private final DocentesRepositoryInt docenteRepository;

    // ModelMappers
    private final ModelMapper formatoAModelMapper;

    public GestionarFormatoAGatewayImplAdapter(
            FormatosRepositoryInt formatoARepository,
            DocentesRepositoryInt docenteRepository,
            EstadoRepositoryInt estadoRepository,
            ModelMapper formatoAModelMapper) {

        this.formatoARepository = formatoARepository;
        this.docenteRepository = docenteRepository;
        this.formatoAModelMapper = formatoAModelMapper;

    }

    // Método para verificar si existe un formato con el mismo titulo
    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoAConTitulo(String titulo) {

        return formatoARepository.existeFormatoAConTitulo(titulo) > 0;
    }

    // Método para guardar un Formato PPA
    @Override
    @Transactional
    public FormatoPPA guardarFormatoPPA(FormatoPPA formatoPPA) {

        // Mapear el modelo de dominio a la entidad específica de PPA
        FormatoPPAEntity formatoPPAEntity = formatoAModelMapper.map(formatoPPA, FormatoPPAEntity.class);

        // Obtener el objeto Docente del dominio
        Docente docenteDominio = formatoPPA.getObjDocente();

        DocenteEntity docenteEntity = null;

        // Si el docente del dominio no es nullo y tiene id
        if (docenteDominio != null && docenteDominio.getId_docente() != null) {
            Integer id_docente = docenteDominio.getId_docente();

            // Si existe el docente en la base de datos
            if (docenteRepository.existsById(id_docente)) {
                // Asociar docente como entidad gestionada
                docenteEntity = docenteRepository.findById(id_docente)
                        .orElseThrow(() -> new RuntimeException("Docente con ID " + id_docente + " no encontrado."));
            } else {
                docenteEntity= new DocenteEntity();
                docenteEntity.setApellidos_docente(docenteDominio.getApellidos_docente());
                docenteEntity.setCorreo(docenteDominio.getCorreo());
                docenteEntity.setNombre_grupo(docenteDominio.getNombre_grupo());
                docenteEntity.setNombres_docente(docenteDominio.getNombres_docente());

            }
            formatoPPAEntity.setObjDocente(docenteEntity);
        }

        // Guardar el Formato PPA
        FormatoPPAEntity formatoPPAGuardado = formatoARepository.save(formatoPPAEntity);

        // Mapear la entidad guardada de nuevo al modelo de dominio
        return formatoAModelMapper.map(formatoPPAGuardado, FormatoPPA.class);
    }

    // Método para guardar un Formato TIA
    @Override
    @Transactional
    public FormatoTIA guardarFormatoTIA(FormatoTIA formatoTIA) {

        // Mapear el modelo de dominio a la entidad específica de TIA
        FormatoTIAEntity formatoTIAEntity = formatoAModelMapper.map(formatoTIA, FormatoTIAEntity.class);

        // Obtener el objeto Docente del dominio
        Docente docenteDominio = formatoTIA.getObjDocente();

        DocenteEntity docenteEntity = null;

        // Si el docente del dominio no es nullo y tiene id
        if (docenteDominio != null && docenteDominio.getId_docente() != null) {
            Integer id_docente = docenteDominio.getId_docente();

            // Si existe el docente en la base de datos
            if (docenteRepository.existsById(id_docente)) {
                // Asociar docente como entidad gestionada
                docenteEntity = docenteRepository.findById(id_docente)
                        .orElseThrow(() -> new RuntimeException("Docente con ID " + id_docente + " no encontrado."));
                formatoTIAEntity.setObjDocente(docenteEntity);
            } else {
                docenteEntity= new DocenteEntity();
                docenteEntity.setApellidos_docente(docenteDominio.getApellidos_docente());
                docenteEntity.setCorreo(docenteDominio.getCorreo());
                docenteEntity.setNombre_grupo(docenteDominio.getNombre_grupo());
                docenteEntity.setNombres_docente(docenteDominio.getNombres_docente());
            }
            formatoTIAEntity.setObjDocente(docenteEntity);
        }

        // Guardar el Formato TIA
        FormatoTIAEntity formatoTIAGuardado = formatoARepository.save(formatoTIAEntity);

        // Mapear la entidad guardada de nuevo al modelo de dominio
        return formatoAModelMapper.map(formatoTIAGuardado, FormatoTIA.class);
    }

    // Método para obtener un Docente por su id
    @Override
    @Transactional(readOnly = true)
    public Docente obtenerDocentePorId(Integer id_docente) {
        DocenteEntity docenteEntity = docenteRepository.findById(id_docente).orElse(null);
                if (docenteEntity != null) {

            return formatoAModelMapper.map(docenteEntity, Docente.class);
        }
        return null;
    }

    // Método para verificar si ya esxiste un docente con el mismo correo
    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorCorreo(String correo) {
        Integer cantidad = docenteRepository.existeDocenteConCorreo(correo);
        return cantidad != null && cantidad > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> obtenerFormatoAConDocentePorId(Integer id_docente) {
        List<FormatoAEntity> formatosEntity = this.formatoARepository.obtenerConDocentePorId(id_docente);
        List<FormatoA> formatoa = null;
        if (formatosEntity != null) {
            formatoa = formatosEntity.stream().map(formatoEntity ->{
                if(formatoEntity instanceof FormatoPPAEntity){
                    return this.formatoAModelMapper.map(formatoEntity, FormatoPPA.class);
                }else{
                    return this.formatoAModelMapper.map(formatoEntity, FormatoTIA.class);
                }
                
            }).toList();
        }
        return formatoa;
    }

    @Override
    public List<FormatoA> buscarFormatoADocentePorFecha(Integer id_docente, Date fechaInicio, Date fechaFin) {
        List<FormatoAEntity> formatosEntity = this.formatoARepository.obtenerConDocentePorIdFecha(id_docente,fechaInicio,fechaFin);
        List<FormatoA> formatoa = null;
        if (formatosEntity != null) {
            formatoa = formatosEntity.stream().map(formatoEntity ->{
                if(formatoEntity instanceof FormatoPPAEntity){
                    return this.formatoAModelMapper.map(formatoEntity, FormatoPPA.class);
                }else{
                    return this.formatoAModelMapper.map(formatoEntity, FormatoTIA.class);
                }
                
            }).toList();
        }
        return formatoa;
    }

}
