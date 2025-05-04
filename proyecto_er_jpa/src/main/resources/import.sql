--Docentes
INSERT INTO `docentes` (`idDocente`, `nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES (NULL, "grupo1", "Perez Pancho", "pp@unicauca.edu.co", "Pepito")
INSERT INTO `docentes` (`idDocente`, `nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES (NULL, "grupo1", "Piamba Mosquera", "PM@unicauca.edu.co", "Juanes")
INSERT INTO `docentes` (`idDocente`, `nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES (NULL, "grupo1", "Ruano Molano", "RM@unicauca.edu.co", "David")
--Rol
INSERT INTO `roles` (`idRol`, `rol_asignado`) VALUES (NULL, "Miembro")
--Historico
INSERT INTO `historicos` (`activo`, `idHistorico`,`idfkDocente`,`idfkRol`,`fechaFin`,`fechaInicio`) VALUES (1,NULL,1,1,"2025-04-22","2025-01-22")
INSERT INTO `historicos` (`activo`, `idHistorico`,`idfkDocente`,`idfkRol`,`fechaFin`,`fechaInicio`) VALUES (1,NULL,2,1,"2025-04-22","2025-01-22")
INSERT INTO `historicos` (`activo`, `idHistorico`,`idfkDocente`,`idfkRol`,`fechaFin`,`fechaInicio`) VALUES (1,NULL,3,1,"2025-04-22","2025-01-22")
--Evaluacion
--INSERT INTO `evaluaciones` (`idEvaluacion`, `idfkFormatoA`, `fecha_registro_concepto`, `nombre_coordinador`, `concepto`) VALUES (NULL, 1, "2025-04-22", "Juanito Morales", "Por corregir")
