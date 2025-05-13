package com.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario;
        String contrasena;
        String tipoCuenta;

        
        System.out.print("Cree una cuenta: ");
        usuario = scanner.nextLine();
        System.out.print("Cree una contraseña: ");
        contrasena = scanner.nextLine();
        System.out.println("Registro válido en CedAsistencia.\n");

        System.out.println("Inicio de sesión");
        System.out.print("Ingrese su usuario: ");
        String u = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String c = scanner.nextLine();

        if (u.equals(usuario) && c.equals(contrasena)) {
            System.out.println("Inicio de sesión válido.\n");

            System.out.println("Seleccione su tipo de usuario: estudiante o docente");
            System.out.print("Elija su cuenta para verificar: ");
            tipoCuenta = scanner.nextLine();

            if (tipoCuenta.equals("estudiante")) {
                System.out.println("Tipo de cuenta correcto: Estudiante.\n");
            } else if (tipoCuenta.equals("docente")) {
                System.out.println("Tipo de cuenta correcto: Docente.\n");
            } else {
                System.out.println("Tipo de cuenta incorrecto. Por favor escriba exactamente 'estudiante' o 'docente'.");
                scanner.close();
                return;
            }

            int opcion;
            do {
                System.out.println("=== MENÚ PRINCIPAL ===");
                System.out.println("1. Ver perfil");
                System.out.println("2. Marcar asistencia");
                System.out.println("3. Ver historial de asistencia");
                System.out.println("4. Cerrar sesión");
                System.out.print("Seleccione una opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("Mostrando perfil de usuario: " + usuario + " (" + tipoCuenta + ")");
                        break;
                    case 2:
                        System.out.println("Asistencia marcada correctamente.");
                        break;
                    case 3:
                        System.out.println("No hay historial de asistencia aún.");
                        break;
                    case 4:
                        System.out.println("Sesión cerrada. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

                System.out.println(); 

            } while (opcion != 4);

        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

        scanner.close();
    }
}
