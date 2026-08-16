package com.smarttask.service;

import com.smarttask.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Accionable {

    private final List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        tareas = new ArrayList<>();
        siguienteId = 1;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        tarea.setId(siguienteId);
        siguienteId++;
        tareas.add(tarea);
    }

    @Override
    public void listarTareas() {
        System.out.println("TAREAS ACTIVAS");
        boolean hayActivas = false;

        for (Tarea tarea : tareas) {
            if (!tarea.isCompletado()) {
                System.out.println(tarea);
                hayActivas = true;
            }
        }

        if (!hayActivas) {
            System.out.println("No hay tareas activas.");
        }

        System.out.println();
        System.out.println("TAREAS COMPLETADAS");
        boolean hayCompletadas = false;

        for (Tarea tarea : tareas) {
            if (tarea.isCompletado()) {
                System.out.println(tarea);
                hayCompletadas = true;
            }
        }

        if (!hayCompletadas) {
            System.out.println("No hay tareas completadas.");
        }
    }

    @Override
    public void eliminarTarea(int id) {
        Tarea tareaEncontrada = buscarPorId(id);

        if (tareaEncontrada == null) {
            System.out.println("Tarea no encontrada.");
            return;
        }

        tareas.remove(tareaEncontrada);
    }

    @Override
    public void marcarComoCompletada(int id) {
        Tarea tarea = buscarPorId(id);

        if (tarea == null) {
            System.out.println("Tarea no encontrada.");
            return;
        }

        tarea.setCompletado(true);
    }

    private Tarea buscarPorId(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }

        return null;
    }
}
