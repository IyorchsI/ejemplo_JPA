package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Docente;

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
public class DocenteDTOPeticion {

    @NotBlank(message = "{Docente.nombre_grupo.empty}")
    @Size(max = 50, message = "{Docente.nombre_grupo.lenght}")
    private String nombre_grupo;

}
