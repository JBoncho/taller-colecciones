import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion = 0;

        while (opcion != 10) {

            System.out.println("\n-- Agenda contactos --");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos (orden alfabetico)");
            System.out.println("5. Listar historial");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("10. Salir");
            System.out.print("Elegir una opcion: ");

            // Verificar que la entrada sea un numero
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                // Consumir el salto de linea pendiente
                scanner.nextLine();

            } else {
                scanner.nextLine();
                System.out.println("Error: debe ingresar un numero.");
                continue;
            }

            // Validar el rango de opciones
            if (opcion < 1 || opcion > 10) {
                System.out.println("Opcion fuera de rango.");
                continue;
            }

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contacto contacto =
                            new Contacto(nombre, telefono, email);

                    agenda.agregarContacto(contacto);
                    break;

                case 2:
                    System.out.print("Nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();

                    Contacto encontrado =
                            agenda.buscarContacto(nombre);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();

                    agenda.eliminarContacto(nombre);
                    break;

                case 4:
                    System.out.println("\nLista de contactos:");
                    agenda.listarContactos();
                    break;

                case 5:
                    System.out.println("\nHistorial de contactos:");
                    agenda.listarHistorial();
                    break;

                case 6:
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = scanner.nextLine();

                    agenda.agregarGrupo(nombreGrupo);
                    break;

                case 7:
                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();

                    System.out.print("Nombre del grupo: ");
                    nombreGrupo = scanner.nextLine();

                    agenda.agregarContactoAGrupo(
                            nombre, nombreGrupo);
                    break;

                case 8:
                    System.out.println("\nLista de grupos:");
                    agenda.listarGrupos();
                    break;

                case 9:
                    System.out.print("Nombre del grupo: ");
                    nombreGrupo = scanner.nextLine();

                    agenda.mostrarContactosPorGrupo(nombreGrupo);
                    break;

                case 10:
                    System.out.println("Saliendo de la agenda...");
                    break;
            }
        }

        // Cerrar el Scanner al salir
        scanner.close();
    }
}

