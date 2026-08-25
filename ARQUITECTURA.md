# Arquitectura del Proyecto - EduNova (Guatex)

========================================================================================
                          DIAGRAMA DE ARQUITECTURA MVC - EDUNOVA (GUATEX)
========================================================================================

 [ VISTA ]                             [ CONTROLADOR ]                       [ MODELO ]
 (HTML5 / CSS3 / JS)                    (Lógica PHP)                     (PHP / MySQL)

+---------------------+               +-----------------------+             +----------------------+
|  ingreso.html       | --(Submit)--> | LoginController.php   | ->Valida->  | Usuario.php          |
|  (Login por Roles)  |               |                       | <-Retorna<- | (Consulta Credencial)|
+---------------------+               +-----------------------+             +----------------------+
                                                  |
                                         (Decide Redirección)
                                                  v
+---------------------+               +-----------------------+             +----------------------+
| formulario_curso    | --(Submit)--> | CapacitacionController| ->Valida->  | Empleado.php         |
| (Alta y Matrícula)  |               | .php                  |             | Curso.php            |
+---------------------+               |                       | <-Retorna<- | Inscripcion.php      |
                                      +-----------------------+             +----------------------+
                                                  |
                                         (Decide Redirección)
                                                  v
+---------------------+               +-----------------------+             +----------------------+
| reportes.php        | --(Update)--> | ReporteController.php | ->Aplica->  | Inscripcion.php      |
| (Dashboard/Asistencia)              |                       | <-Reglas<-  | (Aprobación >= 80%)  |
+---------------------+               +-----------------------+             +----------------------+