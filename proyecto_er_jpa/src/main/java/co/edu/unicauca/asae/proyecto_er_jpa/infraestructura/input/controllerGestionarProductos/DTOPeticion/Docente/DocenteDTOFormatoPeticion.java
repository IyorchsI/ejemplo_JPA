package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Docente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTOFormatoPeticion {

    private Integer id_docente;
    @NotBlank(message = "{Docente.nombres_docente.empty}")
    @Size(max = 100, message = "{Docente.nombres_docente.lenght}")
    private String nombres_docente;
    @NotBlank(message = "{Docente.apellidos_docente.empty}")
    @Size(max = 50, message = "{Docente.apellidos_docente.lenght}")
    private String apellidos_docente;
    @NotBlank(message = "{Docente.nombre_grupo.empty}")
    @Size(max = 50, message = "{Docente.nombre_grupo.lenght}")
    private String nombre_grupo;
    @NotBlank(message = "{Docente.correo.empty}")
    @Email(message = "{Docente.correo.mask}")    
    private String correo;
    
}
