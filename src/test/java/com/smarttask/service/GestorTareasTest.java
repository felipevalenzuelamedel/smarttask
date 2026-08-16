package com.smarttask.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;

public class GestorTareasTest {

    @Test
    void testAgregarTarea() {
        GestorTareas gestor = new GestorTareas();
        TareaNormal tareaNormal = new TareaNormal(0, "Estudiar Java");
        TareaUrgente tareaUrgente = new TareaUrgente(0, "Entregar proyecto", 3);

        gestor.agregarTarea(tareaNormal);
        gestor.agregarTarea(tareaUrgente);

        assertEquals(1, tareaNormal.getId());
        assertEquals(2, tareaUrgente.getId());

        tareaNormal.setNombre("Estudiar Java actualizado");
        tareaNormal.setId(1);
        tareaNormal.setCompletado(false);
        assertEquals("Estudiar Java actualizado", tareaNormal.getNombre());
        assertEquals(1, tareaNormal.getId());
        assertFalse(tareaNormal.isCompletado());

        tareaUrgente.setDiasLimite(5);
        assertEquals(5, tareaUrgente.getDiasLimite());
        assertFalse(tareaUrgente.estaVencida());

        tareaUrgente.setDiasLimite(0);
        assertTrue(tareaUrgente.estaVencida());
    }

    @Test
    void testListarTareas() {
        GestorTareas gestor = new GestorTareas();
        TareaNormal tareaNormal = new TareaNormal(0, "Estudiar Java");
        TareaUrgente tareaUrgente = new TareaUrgente(0, "Entregar proyecto", 3);

        gestor.agregarTarea(tareaNormal);
        gestor.agregarTarea(tareaUrgente);
        gestor.marcarComoCompletada(1);

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(salida));
            gestor.listarTareas();
        } finally {
            System.setOut(salidaOriginal);
        }

        String resultado = salida.toString();

        assertTrue(resultado.contains("TAREAS ACTIVAS"));
        assertTrue(resultado.contains("[URGENTE] ID: 2 | Nombre: Entregar proyecto | Estado: ACTIVA | Dias limite: 3"));
        assertTrue(resultado.contains("TAREAS COMPLETADAS"));
        assertTrue(resultado.contains("[NORMAL] ID: 1 | Nombre: Estudiar Java | Estado: COMPLETADA"));
        assertFalse(resultado.contains("No hay tareas activas."));
        assertFalse(resultado.contains("No hay tareas completadas."));
    }

    @Test
void testListarTareasSinTareas() {
    GestorTareas gestor = new GestorTareas();

    ByteArrayOutputStream salida = new ByteArrayOutputStream();
    PrintStream salidaOriginal = System.out;

    try {
        System.setOut(new PrintStream(salida));
        gestor.listarTareas();
    } finally {
        System.setOut(salidaOriginal);
    }

    String resultado = salida.toString();

    assertTrue(resultado.contains("TAREAS ACTIVAS"));
    assertTrue(resultado.contains("No hay tareas activas."));
    assertTrue(resultado.contains("TAREAS COMPLETADAS"));
    assertTrue(resultado.contains("No hay tareas completadas."));
}

    @Test
    void testMarcarComoCompletada() {
        GestorTareas gestor = new GestorTareas();
        TareaNormal tarea = new TareaNormal(0, "Estudiar Java");

        gestor.agregarTarea(tarea);
        gestor.marcarComoCompletada(1);

        assertTrue(tarea.isCompletado());

        gestor.marcarComoCompletada(999);
        gestor.eliminarTarea(999);
        gestor.eliminarTarea(1);

        assertTrue(tarea.isCompletado());
    }
}
