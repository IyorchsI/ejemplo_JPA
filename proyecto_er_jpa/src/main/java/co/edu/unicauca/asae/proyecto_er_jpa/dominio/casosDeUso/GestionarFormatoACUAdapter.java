package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Estado;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoPPA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoTIA;

public class GestionarFormatoACUAdapter implements GestionarFormatoACUIntPort {

    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarFormatoACUAdapter(GestionarFormatoAGatewayIntPort objRegistrarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarFormatoAGateway = objRegistrarFormatoAGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    // PUNTO 1. CREAR FORMATOA //
    // Permite Crear un formato PPA
    @Override
    public FormatoPPA crearFormatoPPA(FormatoPPA  objFormatoPPA, Integer id_docente) {

        // Objeto a retornar
        FormatoPPA objFormatoPPACreado = null;
    
        // Verificar si ya existe un formato A con el mismo título
        if (this.objGestionarFormatoAGateway.existeFormatoAConTitulo(objFormatoPPA.getTitulo_formato())) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste(
                    "Error, se encuentra en el sistema un Formato PPA con el título: " + objFormatoPPA.getTitulo_formato());
        } else {
            
            // Validar que el id_docente no sea nulo
            if (id_docente == null) {
                throw new IllegalArgumentException("El ID del docente director no puede ser nulo.");
            }
    
            // Buscar el docente por su ID
            Docente docenteExistente = this.objGestionarFormatoAGateway.obtenerDocentePorId(id_docente);
    
            if (docenteExistente != null) {

                // Si el docente ya existe, asociarlo al formato A
                objFormatoPPA.setObjDocente(docenteExistente);

            } else {

                // Si el docente no existe, crear uno nuevo
                Docente docenteNuevo = new Docente();
                docenteNuevo.setNombres_docente("Oscar");
                docenteNuevo.setApellidos_docente("Hernandez");
                docenteNuevo.setNombre_grupo("Grupo 1");
                docenteNuevo.setCorreo("oscarh@unicauca.edu.co");
    
                // Validar si el correo del docente ya existe en el sistema
                if (this.objGestionarFormatoAGateway.existeDocentePorCorreo(docenteNuevo.getCorreo())) {
                    this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio(
                            "Error, el correo ya existe");
                } else {
                    // Asignar el nuevo docente al formato A
                    objFormatoPPA.setObjDocente(docenteNuevo);
                }
            }
    
            // Crear el estado inicial "En formulación"
            Estado estadoInicial = new Estado();
            estadoInicial.setFecha_registro_estado(new Date());

            // Asignar el formato A al estado
            estadoInicial.setObjFormatoA(objFormatoPPA);
    
            // Asignar el estado al formato A
            objFormatoPPA.setObjEstado(estadoInicial);
    
            // Guardar el Formato PPA con persistencia en cascada
            try {
                return this.objGestionarFormatoAGateway.guardarFormatoPPA(objFormatoPPA);
            } catch (Exception e) {
                e.printStackTrace(); //  esto te dará el error real en consola
                throw e;
            }
        }
    
        return objFormatoPPACreado;
    }

    // Permite Crear un formato TIA
    @Override
    public FormatoTIA crearFormatoTIA(FormatoTIA objFormatoTIA, Integer id_docente) {

        // Objeto a retornar
        FormatoTIA objFormatoTIACreado = null;
    
        // Verificar si ya existe un formato A con el mismo título
        if (this.objGestionarFormatoAGateway.existeFormatoAConTitulo(objFormatoTIA.getTitulo_formato())) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste(
                    "Error, se encuentra en el sistema un Formato TIA con el título: " + objFormatoTIA.getTitulo_formato());
        } else {
            
            // Validar que el id_docente no sea nulo
            if (id_docente == null) {
                throw new IllegalArgumentException("El ID del docente director no puede ser nulo.");
            }
    
            // Buscar el docente por su ID
            Docente docenteExistente = this.objGestionarFormatoAGateway.obtenerDocentePorId(id_docente);
    
            if (docenteExistente != null) {

                // Si el docente ya existe, asociarlo al formato A
                objFormatoTIA.setObjDocente(docenteExistente);

            } else {

                // Si el docente no existe, crear uno nuevo
                Docente docenteNuevo = new Docente();
                docenteNuevo.setNombres_docente("Camilo");
                docenteNuevo.setApellidos_docente("Orozco");
                docenteNuevo.setNombre_grupo("Grupo 1");
                docenteNuevo.setCorreo("camiloo@unicauca.edu.co");
    
                // Validar si el correo del docente ya existe en el sistema
                if (this.objGestionarFormatoAGateway.existeDocentePorCorreo(docenteNuevo.getCorreo())) {
                    this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio(
                            "Error, el correo ya existe");
                } else {
                    // Asignar el nuevo docente al formato A
                    objFormatoTIA.setObjDocente(docenteNuevo);
                }
            }
    
            // Crear el estado inicial "En formulación"
            Estado estadoInicial = new Estado();
            estadoInicial.setFecha_registro_estado(new Date());

            // Asignar el formato A al estado
            estadoInicial.setObjFormatoA(objFormatoTIA);
    
            // Asignar el estado al formato A
            objFormatoTIA.setObjEstado(estadoInicial);
    
            // Guardar el Formato PPA con persistencia en cascada
            try {
                return this.objGestionarFormatoAGateway.guardarFormatoTIA(objFormatoTIA);
            } catch (Exception e) {
                e.printStackTrace(); //  esto te dará el error real en consola
                throw e;
            }
        }
    
        return objFormatoTIACreado;
    }

    @Override
    public List<FormatoA> buscarFormatoAporDocente(Integer id_docente) {
            Docente docenteExistente = this.objGestionarFormatoAGateway.obtenerDocentePorId(id_docente);
            List<FormatoA> resultado = null;
    
            if (docenteExistente != null) {
                resultado = this.objGestionarFormatoAGateway.obtenerFormatoAConDocentePorId(id_docente);
            }

        
        
       return resultado;
    }

    @Override
    public List<FormatoA> buscarFormatoADocentePorFecha(Integer id_docente, Date fechaInicio, Date fechaFin) {
        Docente docenteExistente = this.objGestionarFormatoAGateway.obtenerDocentePorId(id_docente);
            List<FormatoA> resultado = null;
    
            if (docenteExistente != null) {
                resultado = this.objGestionarFormatoAGateway.buscarFormatoADocentePorFecha(id_docente, fechaInicio, fechaFin);
            }

        
        
       return resultado;
    }

}
