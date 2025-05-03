package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    public FormatoTIADTOPeticion(String titulo_formato, String objetivo_general, String objetivos_especificos,
                                 String nombre_estudiante1, Integer id_docente, String nombre_estudiante2) {

        super(titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, id_docente);
        this.nombre_estudiante2 = nombre_estudiante2;
        
    }
    
}
