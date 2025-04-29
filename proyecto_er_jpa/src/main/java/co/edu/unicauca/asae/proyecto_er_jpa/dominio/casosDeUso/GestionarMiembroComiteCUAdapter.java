package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarMiembroComiteCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarMiembroComiteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;

public class GestionarMiembroComiteCUAdapter implements GestionarMiembroComiteCUIntPort{

    private final GestionarMiembroComiteGatewayIntPort objGestionarMiembroComiteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarMiembroComiteCUAdapter(GestionarMiembroComiteGatewayIntPort objRegistrarMiembroComiteGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarMiembroComiteGateway = objRegistrarMiembroComiteGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<Docente> listarMiembrosComite() {
        
        throw new UnsupportedOperationException("Unimplemented method 'listarMiembrosComite'");
    }
    
}
