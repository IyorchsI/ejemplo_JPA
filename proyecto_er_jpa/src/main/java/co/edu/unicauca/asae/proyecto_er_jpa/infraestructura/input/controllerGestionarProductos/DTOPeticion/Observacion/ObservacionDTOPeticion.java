package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Observacion;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionDTOPeticion {
    
    @NotBlank(message = "{observacion.observacion.emply}")
    private String observacion;

    @NotNull(message = "{observacion.id_formato.emply}")
    private Integer id_formato;

    @NotEmpty(message = "{observacion.ids_docentes.emply}")
    private List<@NotNull Integer> ids_docentes;

}
