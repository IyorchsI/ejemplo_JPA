package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objRegistrarDocenteGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarDocenteGateway = objRegistrarDocenteGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<Docente> obtenerDocentesSolicitados(String nombre_grupo) {

        if(!this.objGestionarDocenteGateway.existenDocentesRegistrados()){
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste(
                    "Error, no se encuentran docentes ");
        }

        return this.objGestionarDocenteGateway.obtenerDocentes(nombre_grupo);
    }
    
}
