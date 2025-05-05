package co.edu.unicauca.asae.proyecto_er_jpa.dominio.casosDeUso;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;

import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.input.GestionarObservacionCUIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Evaluacion;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.proyecto_er_jpa.dominio.modelos.Observacion;

public class GestionarObservacionCUAdapter implements GestionarObservacionCUIntPort {

    private final GestionarObservacionGatewayIntPort objGestionarObservacionGateway;
    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarObservacionCUAdapter(GestionarObservacionGatewayIntPort objGestionarObservacionGateway,
            GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarObservacionGateway = objGestionarObservacionGateway;
        this.objGestionarFormatoAGateway = objGestionarFormatoAGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public Observacion crearObservacion(Observacion objObservacion, List<@NotNull Integer> ids_docentes,
            @NotNull Integer id_formato) {

        System.out.println("--ENTRA A CREAR OBSERVACION--");
        if (ids_docentes == null || ids_docentes.isEmpty()) {
            throw new IllegalArgumentException("Debe proporcionar al menos un ID de docente.");
        }

        if (id_formato == null) {
            throw new IllegalArgumentException("Debe proporcionar un ID de Formato A válido.");
        }

        // Obtener la lista de docentes por referencia
        List<Docente> docentes = this.objGestionarObservacionGateway.obtenerDocentesPorIds(ids_docentes);

        System.out.println("--OBTUVO LOS DOCENTES--");

        // Determinar la evaluación asociada
        Integer idEvaluacion = this.objGestionarObservacionGateway.obtenerUltimaEvaluacionPorFormatoA(id_formato);
        Evaluacion evaluacion;

        System.out.println("--OBTIENE LA ULTIMA EVALUACION ASOCIADA--");

        if (idEvaluacion == null) {
            // No existe evaluación -> se debe crear una nueva con concepto "Por establecer"
            System.out.println("--NO EXISTE UNA ULTIMA EVALUACION--");
            evaluacion = new Evaluacion();
            evaluacion.setFecha_registro_concepto(new Date());
            evaluacion.setConcepto("Por establecer");

            // Obtener el formato con el docente para recuperar el nombre del coordinador
            FormatoA formatoCompleto = this.objGestionarFormatoAGateway.obtenerFormatoAConDocentePorId(id_formato)
                    .get(0);

            if (formatoCompleto == null || formatoCompleto.getObjDocente() == null) {
                throw new IllegalStateException("No se pudo obtener el FormatoA con su docente asociado.");
            }

            // Construir evaluación con el nombre del coordinador
            evaluacion.setObjFormatoA(formatoCompleto);
            evaluacion.setNombre_coordinador(formatoCompleto.getObjDocente().getNombres_docente());

            evaluacion = this.objGestionarObservacionGateway.guardarEvaluacion(evaluacion);
            System.out.println("--CREO LA EVALUACION Y LA GUARDO--");
        } else {
            // Evaluación ya existente
            System.out.println("--EXISTE UNA ULTIMA EVALUACION--");
            evaluacion = this.objGestionarObservacionGateway.obtenerEvaluacionPorId(idEvaluacion);

            if (!"Por corregir".equalsIgnoreCase(evaluacion.getConcepto())) {
                // Si no está en "Por corregir", crear una nueva
                System.out.println("--NO ESTA EN POR CORREGIR--");
                evaluacion = new Evaluacion();
                evaluacion.setFecha_registro_concepto(new Date());
                evaluacion.setConcepto("Por establecer");

                // Obtener el formato con el docente para recuperar el nombre del coordinador
                FormatoA formatoCompleto = this.objGestionarFormatoAGateway.obtenerFormatoAConDocentePorId(id_formato)
                        .get(0);

                if (formatoCompleto == null || formatoCompleto.getObjDocente() == null) {
                    throw new IllegalStateException("No se pudo obtener el FormatoA con su docente asociado.");
                }

                // Construir evaluación con el nombre del coordinador
                evaluacion.setObjFormatoA(formatoCompleto);
                evaluacion.setNombre_coordinador(formatoCompleto.getObjDocente().getNombres_docente());

                evaluacion = this.objGestionarObservacionGateway.guardarEvaluacion(evaluacion);
                System.out.println("--CREO UNA EVALUACION EN POR CORREGIR--");
            }
        }

        // Asociar evaluación y docentes
        objObservacion.setObjEvaluacion(evaluacion);
        objObservacion.setListaDocentes(docentes);
        objObservacion.setFecha_registro_observacion(new Date());

        System.out.println("--ASOCIO LA EVALUACION Y LOS DOCENTES--");

        // Guardar observación y retornar
        return this.objGestionarObservacionGateway.guardarObservacion(objObservacion);
    }

    @Override
    public FormatoA obtenerFormatoConObservacionesPorId(Integer id_formato) {

        // Llamar al gateway
        FormatoA formato = this.objGestionarObservacionGateway.obtenerFormatoAConObservaciones(id_formato);

        if (formato == null) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("No se encontró el formato A con el ID: " + id_formato);
        }

        return formato;
    }

}
