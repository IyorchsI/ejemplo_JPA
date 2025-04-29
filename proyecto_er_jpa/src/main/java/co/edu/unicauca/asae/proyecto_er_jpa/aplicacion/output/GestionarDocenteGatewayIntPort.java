package co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output;

public interface GestionarDocenteGatewayIntPort {
    
    public Boolean existeDocentePorCorreo(String correo);

    public Boolean existeDocenteDuplicado(Integer id_docente);

}
