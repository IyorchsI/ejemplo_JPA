package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIADTOPeticion extends FormatoADTOPeticion {


    @NotBlank(message = "{FormatoTIA.nombre_estudiante2.empty}")
    @Size(max = 100, message = "{FormatoTIA.nombre_estudiante2.lenght}")
    private String nombre_estudiante2;

    @NotBlank(message = "{FormatoTIA.codigo_estudiante2.empty}")
    @Pattern(message = "{FormatoTIA.codigo_estudiante2.pattern}", regexp = "[1046][0-12]{1}")
    @PositiveOrZero(message = "{FormatoTIA.codigo_estudiante2.positive}")
    private Integer codigo_estudiante2;

    public FormatoTIADTOPeticion(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, Integer codigo_estudiante1, Integer id_docente, String nombre_estudiante2, Integer codigo_estudiante2) {
        super(titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, codigo_estudiante1);
        this.nombre_estudiante2=nombre_estudiante2;
        this.codigo_estudiante2=codigo_estudiante2;
    }
    
    
}
