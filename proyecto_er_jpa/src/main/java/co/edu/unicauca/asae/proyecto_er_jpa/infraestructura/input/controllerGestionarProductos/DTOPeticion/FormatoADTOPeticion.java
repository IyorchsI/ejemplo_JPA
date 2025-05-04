package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// No debe enviar el id del formato A, pero si debe enviar el id del docente director.
@Getter
@Setter
@AllArgsConstructor
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include =  JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatoPPADTOPeticion.class, name = "PPA"),
    @JsonSubTypes.Type(value = FormatoTIADTOPeticion.class, name = "TIA")   
})
public abstract class FormatoADTOPeticion {

    @NotBlank(message = "{FormatoA.titulo_formato.empty}")
    @Size(max = 100, message = "{FormatoA.titulo_formato.lenght}")
    private String titulo_formato;

    @NotBlank(message = "{FormatoA.objetivo_general.empty}")
    private String objetivo_general;

    @NotBlank(message = "{FormatoA.objetivos_especificos.empty}")
    private String objetivos_especificos;

    @NotBlank(message = "{FormatoA.nombre_estudiante1.empty}")
    @Size(max = 100, message = "{FormatoA.nombre_estudiante1.lenght}")
    private String nombre_estudiante1;

    @NotBlank(message = "{FormatoA.codigo_estudiante1.empty}")
    @Pattern(message = "{FormatoA.codigo_estudiante1.pattern}", regexp = "[1046][0-12]{1}")
    @PositiveOrZero(message = "{FormatoA.codigo_estudiante1.positive}")
    private Integer codigo_estudiante1;

    /*@NotNull(message = "{Docente.id_docente.empty}")
    @PositiveOrZero(message = "{Docente.id_docente.positive}")
    private Integer id_docente; */
    
}
