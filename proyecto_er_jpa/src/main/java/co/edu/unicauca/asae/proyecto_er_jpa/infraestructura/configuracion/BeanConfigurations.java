package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarDocenteCUAdapter;
//import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarMiembroComiteGatewayIntPort;
//import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarFormatoACUAdapter;
//import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarMiembroComiteCUAdapter;
//import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarObservacionCUAdapter;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso.GestionarObservacionCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarFormatoACUAdapter crearGestionarFormatoACUInt(
            GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        return new GestionarFormatoACUAdapter(objGestionarFormatoAGateway, objFormateadorResultados);
    }

    @Bean
    public GestionarObservacionCUAdapter crearGestionarObservacionCUInt(
            GestionarObservacionGatewayIntPort objGestionarObservacionGateway,
            GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        return new GestionarObservacionCUAdapter(objGestionarObservacionGateway, objGestionarFormatoAGateway, objFormateadorResultados);
    }
    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objFormateadorResultados){
                return new GestionarDocenteCUAdapter(objGestionarDocenteGateway, objFormateadorResultados);
            }
    
}
