package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarMiembroComiteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarFormatoACUAdapter;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarMiembroComiteCUAdapter;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarObservacionCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarFormatoACUAdapter crearGestionarFormatoACUInt(
            GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        GestionarFormatoACUAdapter objGestionarFormatoACU = new GestionarFormatoACUAdapter(objGestionarFormatoAGateway,
                objFormateadorResultados);
        return objGestionarFormatoACU;
    }

    @Bean
    public GestionarFormatoACUAdapter crearGestionarFormatoACU(
            GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        return new GestionarFormatoACUAdapter(objGestionarFormatoAGateway, objFormateadorResultados);
    }

    @Bean
    public GestionarMiembroComiteCUAdapter crearGestionarMiembroComiteCUInt(
            GestionarMiembroComiteGatewayIntPort objGestionarMiembroComiteGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        return new GestionarMiembroComiteCUAdapter(objGestionarMiembroComiteGateway, objFormateadorResultados);
    }

    @Bean
    public GestionarObservacionCUAdapter crearGestionarObservacionCUInt(
            GestionarObservacionGatewayIntPort objGestionarObservacionGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        return new GestionarObservacionCUAdapter(objGestionarObservacionGateway, objFormateadorResultados);
    }

}
