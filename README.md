# SMARTTASK

## Descripción

SMARTTASK es una aplicación de consola desarrollada en Java para administrar tareas personales.

La aplicación permite:

- Agregar tareas normales y urgentes.
- Listar tareas activas y completadas.
- Marcar tareas como completadas.
- Eliminar tareas.
- Gestionar las tareas mediante un menú interactivo por consola.

El proyecto utiliza Maven para la gestión y compilación, JUnit 5 para las pruebas unitarias y JaCoCo para medir la cobertura de código.

---

## Tecnologías utilizadas

- Java 17 (versión objetivo de compilación)
- Maven 3.9.16
- JUnit 5.10.2
- JaCoCo 0.8.14

---

## Estructura del proyecto

```text
SMARTTASK/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── smarttask/
│   │               ├── Main.java
│   │               ├── model/
│   │               │   ├── Tarea.java
│   │               │   ├── TareaNormal.java
│   │               │   └── TareaUrgente.java
│   │               └── service/
│   │                   ├── Accionable.java
│   │                   └── GestorTareas.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── smarttask/
│                   └── service/
│                       └── GestorTareasTest.java
│
├── Bitacora Proyecto Modulo 4.docx
├── log_ejecucion.txt
├── log_tests.txt
├── pom.xml
├── README.md
└── .gitignore
## Enlace al repositorio

https://github.com/felipevalenzuelamedel/smarttask

