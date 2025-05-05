package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Formatos;

import java.util.Date;

import co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTOPeticion.Docente.DocenteDTOFormatoPeticion;
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
public class FormatoPPADTOPeticion extends FormatoADTOPeticion {

    @NotBlank(message = "{formatoPPA.nombreAsesor.empty}")
    @Size(max = 100, message = "{formatoPPA.nombreAsesor.size}")
    private String nombre_asesor;

    @NotBlank(message = "{formatoPPA.rutaCarta.empty}")
    @Size(max = 255, message = "{formatoPPA.rutaCarta.size}")
    private String ruta_carta_aceptacion;

    public FormatoPPADTOPeticion(String titulo_formato, String objetivo_general, String objetivos_especificos,
            String nombre_estudiante1, String codigo_estudiante1,
            Date fecha_registro, DocenteDTOFormatoPeticion objDocente,
            String nombre_asesor, String ruta_carta_aceptacion) {

        super(titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, codigo_estudiante1,
                fecha_registro, objDocente);
        this.nombre_asesor = nombre_asesor;
        this.ruta_carta_aceptacion = ruta_carta_aceptacion;

    }
}
