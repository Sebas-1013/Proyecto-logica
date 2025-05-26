package com.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto {

    static String nombreUsuario;
    static String contrasena;
    static String tipoCuenta;
    static ArrayList<String> excusas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        registrarUsuario(scanner);
        if (iniciarSesion(scanner)) {
            seleccionarTipoCuenta(scanner);
            mostrarMenu(scanner);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

        scanner.close();
    }

    public static void registrarUsuario(Scanner scanner) {
        System.out.println("=== Registro de Usuario ===");
        System.out.print("Cree su nombre de usuario: ");
        nombreUsuario = scanner.nextLine();
        System.out.print("Cree una contraseña: ");
        contrasena = scanner.nextLine();
        System.out.println("Registro válido en CedAsistencia.\n");
    }

    public static boolean iniciarSesion(Scanner scanner) {
        System.out.println("=== Inicio de sesión ===");
        System.out.print("Ingrese su usuario: ");
        String usuarioIngresado = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasenaIngresada = scanner.nextLine();

        return usuarioIngresado.equals(nombreUsuario) && contrasenaIngresada.equals(contrasena);
    }

    public static void seleccionarTipoCuenta(Scanner scanner) {
        System.out.println("Seleccione su tipo de usuario: estudiante o docente");
        System.out.print("Elija su cuenta para verificar: ");
        tipoCuenta = scanner.nextLine();

        if (tipoCuenta.equals("estudiante") || tipoCuenta.equals("docente")) {
            System.out.println("Tipo de cuenta correcto: " + tipoCuenta + ".\n");
        } else {
            System.out.println("Tipo de cuenta incorrecto. Por favor escriba exactamente 'estudiante' o 'docente'.");
            System.exit(0);
        }
    }

    public static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ver perfil");
            System.out.println("2. Marcar asistencia");
            System.out.println("3. Ver historial de asistencia");
            System.out.println("4. Registrar excusa");
            System.out.println("5. Ver excusas registradas");
            System.out.println("6. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    verPerfil();
                    break;
                case 2:
                    marcarAsistencia();
                    break;
                case 3:
                    verHistorialAsistencia();
                    break;
                case 4:
                    registrarExcusa(scanner);
                    break;
                case 5:
                    verExcusas();
                    break;
                case 6:
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 6);
    }

    public static void verPerfil() {
        System.out.println("Usuario: " + nombreUsuario + " (" + tipoCuenta + ")");
    }

    public static void marcarAsistencia() {
        System.out.println("Asistencia marcada correctamente.");
    }

    public static void verHistorialAsistencia() {
        System.out.println("No hay historial de asistencia aún.");
    }

    public static void registrarExcusa(Scanner scanner) {
        System.out.print("Ingrese la fecha de la excusa (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese el motivo: ");
        String motivo = scanner.nextLine();
        excusas.add("Fecha: " + fecha + " | Motivo: " + motivo);
        System.out.println("Excusa registrada correctamente.");
    }

    public static void verExcusas() {
        if (excusas.isEmpty()) {
            System.out.println("No hay excusas registradas.");
        } else {
            System.out.println("Excusas registradas:");
            for (String excusa : excusas) {
                System.out.println(excusa);
            }
        }
    }
}
