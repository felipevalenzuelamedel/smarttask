# SMARTTASK

## Descripción

SMARTTASK es una aplicación de consola desarrollada en Java para administrar tareas personales. Permite agregar tareas normales y urgentes, listar tareas activas y completadas, marcar tareas como completadas y eliminar tareas. El proyecto utiliza Maven y pruebas unitarias con JUnit 5.

## Cómo compilar

Desde la raíz del proyecto, ejecutar:

```bash
mvn clean compile
```

## Cómo ejecutar

Primero compilar el proyecto y luego ejecutar la clase `Main` desde el entorno de desarrollo.

También puede ejecutarse desde Maven utilizando el plugin de ejecución si se configura en el entorno correspondiente.

Para ejecutar las pruebas:

```bash
mvn test
```

Para generar el reporte de cobertura:

```bash
mvn test
```

El reporte de JaCoCo queda disponible en:

```text
target/site/jacoco/index.html
```

## Estructura de clases

```text
src/
├── main/
│   └── java/
│       └── com/
│           └── smarttask/
│               ├── Main.java
│               ├── model/
│               │   ├── Tarea.java
│               │   ├── TareaNormal.java
│               │   └── TareaUrgente.java
│               └── service/
│                   ├── Accionable.java
│                   └── GestorTareas.java
└── test/
    └── java/
        └── com/
            └── smarttask/
                └── service/
                    └── GestorTareasTest.java
```

## Enlace al repositorio

https://github.com/felipevalenzuelamedel/smarttask
