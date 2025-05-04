package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPADTOPeticion extends FormatoADTOPeticion{
    
    @NotBlank(message = "{FormatoPPA.nombre_asesor.empty}")
    @Size(max = 100, message = "{FormatoPPA.nombre_asesor.lenght}")
    private String nombre_asesor;
    
    @NotBlank(message = "{FormatoPPA.ruta_carta_aceptacion.empty}")
    @Size(max = 100, message = "{FormatoPPA.ruta_carta_aceptacion.lenght}")
    private String ruta_carta_aceptacion;

    public FormatoPPADTOPeticion(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, Integer codigo_estudiante1, Integer id_docente, String nombre_asesor, String ruta_carta_aceptacion) {
        super(titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, codigo_estudiante1);
        this.nombre_asesor=nombre_asesor;
        this.ruta_carta_aceptacion=ruta_carta_aceptacion;
    }
    
}
