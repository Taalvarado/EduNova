# Arquitectura de 3 Capas - EduNova (Guatex)

==================================================================================================
                 ARQUITECTURA DE 3 CAPAS (DESACOPLADA) — EDUNOVA (GUATEX)
==================================================================================================

 [ CAPA DE PRESENTACIÓN ]
   │
   ├── Vistas: ingreso.html | formulario_curso.html | reportes.php
   │
   └── Controladores: LoginController | CapacitacionController | ReporteController
         │
         │ (Invocación directa únicamente a la Capa de Negocio)
         ▼
 [ CAPA DE NEGOCIO (SERVICIOS) ]
   │
   ├── EmpleadoService      --> Valida código único y estado 'Activo'
   ├── CursoService         --> Valida cupo máximo y disponibilidad de fechas
   └── InscripcionService   --> Evalúa porcentaje >= 80% para marcar 'Completado'
         │
         │ (Invocación de persistencia únicamente a la Capa de Datos)
         ▼
 [ CAPA DE DATOS (REPOSITORIOS Y ENTIDADES) ]
   │
   ├── Entidades: Empleado | Curso | Inscripcion | Usuario
   │
   └── Repositorios: EmpleadoRepository | CursoRepository | InscripcionRepository