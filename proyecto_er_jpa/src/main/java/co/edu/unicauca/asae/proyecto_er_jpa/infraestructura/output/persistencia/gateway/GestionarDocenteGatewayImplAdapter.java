package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.respositorios.DocentesRepositoryInt;

@Service
@Transactional
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocentesRepositoryInt docenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(
            DocentesRepositoryInt docenteRepository,
            ModelMapper docenteModelMapper) {

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
    
}
