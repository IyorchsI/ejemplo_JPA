package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos;

import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Docente.DocenteDTOFormatoPeticion;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// No debe enviar el id del formato A, pero si debe enviar el id del docente director.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoADTOPeticion {

    @NotBlank(message = "{formatoA.titulo.emply}")
    @Size(max = 100, message = "{formatoA.titulo.size}")
    private String titulo_formato;

    @NotBlank(message = "{formatoA.objGeneral.emply}")
    private String objetivo_general;

    @NotBlank(message = "{formatoA.objEspecificos.emply}")
    private String objetivos_especificos;

    @NotBlank(message = "{formatoA.nombreEstudiante1.emply}")
    @Size(min = 2, max = 100, message = "{formatoA.nombreEstudiante1.size}")
    private String nombre_estudiante1;

    @NotBlank(message = "{FormatoA.codigo_estudiante1.empty}")
    @Pattern(message = "{FormatoA.codigo_estudiante1.pattern}", regexp = "^1046\\d{8}$")
    private String codigo_estudiante1;

    @NotNull(message = "{FormatoA.fecha_registro.empty}")
    @PastOrPresent(message = "{Estado.fecha_registro_estado.past}")
    private Date fecha_registro;

    @NotNull(message = "Docente.objDocente.empty")
    @Valid
    private DocenteDTOFormatoPeticion objDocente;
}
