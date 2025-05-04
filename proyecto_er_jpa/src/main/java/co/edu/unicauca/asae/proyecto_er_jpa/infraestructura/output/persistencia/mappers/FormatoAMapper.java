package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.output.persistencia.mappers;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FormatoAMapper {
    @Bean
    public ModelMapper crearFormatoAMapper() {
        return new ModelMapper();
    }
}
