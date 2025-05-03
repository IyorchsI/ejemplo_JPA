package co.edu.unicauca.asae.proyecto_er_jpa.infraestructura.input.controllerGestionarProductos.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoTIADTORespuesta extends FormatoADTORespuesta {

    private String nombre_estudiante2;

    public FormatoTIADTORespuesta(Integer id_formato, String titulo_formato, String objetivo_general,
            String objetivos_especificos, String nombre_estudiante1, String estado_actual,
            String nombres_docente, String nombre_estudiante2) {

        super(id_formato, titulo_formato, objetivo_general, objetivos_especificos, nombre_estudiante1, estado_actual,
                nombres_docente);
        this.nombre_estudiante2 = nombre_estudiante2;
        
    }

}
