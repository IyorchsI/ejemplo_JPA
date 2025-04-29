package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarObservacionCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public class GestionarObservacionCUAdapter implements GestionarObservacionCUIntPort{

    private final GestionarObservacionGatewayIntPort objGestionarObservacionGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarObservacionCUAdapter(GestionarObservacionGatewayIntPort objRegistrarObservacionGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarObservacionGateway = objRegistrarObservacionGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public Observacion crearObservacion(Observacion observacion) {
        
        throw new UnsupportedOperationException("Unimplemented method 'crearObservacion'");
    }

    @Override
    public List<Observacion> listarObservaciones() {
        
        throw new UnsupportedOperationException("Unimplemented method 'listarObservaciones'");
    }
    
}
