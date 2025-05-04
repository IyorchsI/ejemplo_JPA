package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

public interface FormateadorResultadosIntPort {
    
    void retornarRespuestaErrorEntidadExiste(String mensaje);

    void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}
