package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
    @Size(max = 100, message = "{formatoA.nombreEstudiante1.size}")
    private String nombre_estudiante1;

    @NotBlank(message = "{FormatoA.codigo_estudiante1.empty}")
    @Pattern(message = "{FormatoA.codigo_estudiante1.pattern}", regexp = "^1046\\d{8}$")
    private String codigo_estudiante1;

    @NotBlank(message = "{FormatoA.fecha_registro.empty}")
    private Date fecha_registro;

    @NotNull(message = "{formatoA.id_docente.emply}")
    @PositiveOrZero(message = "{formatoA.id_docente.positive}")
    private Integer id_docente;
}
