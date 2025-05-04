package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.HistoricoEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.MiembrosRepositoryInt;

@Service
@Transactional
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocentesRepositoryInt docenteRepository;
    private final ModelMapper docenteModelMapper;
    private final MiembrosRepositoryInt historicoRepository;

    public GestionarDocenteGatewayImplAdapter(
            DocentesRepositoryInt docenteRepository,
            MiembrosRepositoryInt historicoRepository,
            ModelMapper docenteModelMapper) {
        this.historicoRepository = historicoRepository;
        this.docenteRepository = docenteRepository;
        this.docenteModelMapper = docenteModelMapper;
            }

    @Override
    @Transactional(readOnly = true)
    public boolean existenDocentesRegistrados() {
        
        return docenteRepository.existenDocentes() > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> obtenerDocentes(String nombre_grupo) {
        //List<DocenteEntity> docentesEntity = docenteRepository.findByNombre_grupoIgnoreCaseOrderByApellidos_docenteASC(nombre_grupo);
        
        List<DocenteEntity> docentesEntity = docenteRepository.buscarPorNombreGrupoOrdenadoPorApellido(nombre_grupo);
        List<Docente> docentes = null;
        if (docentesEntity != null) {

            docentes = docentesEntity.stream().map(docenteEntity ->{
                return this.docenteModelMapper.map(docenteEntity, Docente.class);
            }).toList();
        }
		
        return docentes;
    }
    
    public List<Historico> listarMiembrosComite() {
        Iterable<HistoricoEntity> historicosEntityIterable = historicoRepository.findAll();

        List<HistoricoEntity> historicosEntity = StreamSupport
            .stream(historicosEntityIterable.spliterator(), false)
            .collect(Collectors.toList());

        List<Historico> historicos = new ArrayList<>();
        for (HistoricoEntity entity : historicosEntity) {
            Historico historico = docenteModelMapper.map(entity, Historico.class);
            historicos.add(historico);
        }

        return historicos;
    }

}
