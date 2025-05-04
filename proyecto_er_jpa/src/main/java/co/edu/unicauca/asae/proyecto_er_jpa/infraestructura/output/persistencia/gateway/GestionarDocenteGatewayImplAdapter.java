package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.HistoricoEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.MiembrosRepositoryInt;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort{
    
    // Repositorios
    private final MiembrosRepositoryInt historicoRepository;

    // ModelMappers
    private final ModelMapper formatoAModelMapper;

    public GestionarDocenteGatewayImplAdapter(
            MiembrosRepositoryInt historicoRepository,
            ModelMapper formatoAModelMapper) {

        this.historicoRepository = historicoRepository;
        this.formatoAModelMapper = formatoAModelMapper;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Historico> listarMiembrosComite() {
        Iterable<HistoricoEntity> historicosEntityIterable = historicoRepository.findAll();

        List<HistoricoEntity> historicosEntity = StreamSupport
            .stream(historicosEntityIterable.spliterator(), false)
            .collect(Collectors.toList());

        List<Historico> historicos = new ArrayList<>();
        for (HistoricoEntity entity : historicosEntity) {
            Historico historico = formatoAModelMapper.map(entity, Historico.class);
            historicos.add(historico);
        }

        return historicos;
    }

}
