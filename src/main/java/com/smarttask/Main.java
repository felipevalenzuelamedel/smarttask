package com.smarttask;

import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import com.smarttask.service.GestorTareas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        agregarTarea(scanner, gestor);
                        break;
                    case 2:
                        gestor.listarTareas();
                        break;
                    case 3:
                        System.out.print("Ingrese el ID de la tarea: ");
                        int idCompletar = Integer.parseInt(scanner.nextLine());
                        gestor.marcarComoCompletada(idCompletar);
                        break;
                    case 4:
                        System.out.print("Ingrese el ID de la tarea: ");
                        int idEliminar = Integer.parseInt(scanner.nextLine());
                        gestor.eliminarTarea(idEliminar);
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Entrada inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
            }

            if (continuar) {
                System.out.println();
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== SMARTTASK =====");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarTarea(Scanner scanner, GestorTareas gestor) {
        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();

        System.out.println("Tipo de tarea:");
        System.out.println("1. Normal");
        System.out.println("2. Urgente");
        System.out.print("Seleccione el tipo: ");

        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            gestor.agregarTarea(new TareaNormal(0, nombre));
        } else if (tipo == 2) {
            System.out.print("Ingrese diasLimite: ");
            int diasLimite = Integer.parseInt(scanner.nextLine());
            gestor.agregarTarea(new TareaUrgente(0, nombre, diasLimite));
        } else {
            System.out.println("Entrada inválida. Intente nuevamente.");
        }
    }
}
