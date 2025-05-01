package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

//import java.util.List;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;

public class GestionarFormatoACUAdapter implements GestionarFormatoACUIntPort {

    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarFormatoACUAdapter(GestionarFormatoAGatewayIntPort objRegistrarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarFormatoAGateway = objRegistrarFormatoAGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public FormatoA crearFormatoA(FormatoA objFormatoA, Integer id_docente) {
        
        throw new UnsupportedOperationException("Unimplemented method 'crearFormatoA'");
    }

    /* 
    @Override
    public List<FormatoA> consultarFormatosAPorDocente(Integer id_docente) {
        
        throw new UnsupportedOperationException("Unimplemented method 'consultarFormatosAPorDocente'");
    }
    */

}
