package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos;


import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoTIADTOPeticion extends FormatoADTOPeticion{

    @NotBlank(message = "{formatoTIA.nombreEstudiante2.empty}")
    @Size(max = 100, message = "{formatoTIA.nombreEstudiante2.size}")
    private String nombre_estudiante2;

    @NotBlank(message = "{FormatoTIA.codigo_estudiante2.empty}")
    @Pattern(message = "{FormatoTIA.codigo_estudiante2.pattern}", regexp = "^1046\\d{8}$")
    private String codigo_estudiante2;

    public FormatoTIADTOPeticion(String titulo_formato, String objetivo_general, String objetivos_especificos,
                                 String nombre_estudiante1,String codigo_estudiante1,
            Date fecha_registro, Integer id_docente, String nombre_estudiante2, String codigo_estudiante2) {

        super(titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1,codigo_estudiante1,
        fecha_registro, id_docente);
        this.nombre_estudiante2 = nombre_estudiante2;
        this.codigo_estudiante2=codigo_estudiante2;
        
    }
    
}
