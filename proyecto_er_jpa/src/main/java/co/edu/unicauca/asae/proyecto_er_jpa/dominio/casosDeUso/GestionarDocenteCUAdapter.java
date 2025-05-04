package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Historico;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{
    
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<Historico> listarMiembrosComite() {
        return objGestionarDocenteGateway.listarMiembrosComite();
    }

}
