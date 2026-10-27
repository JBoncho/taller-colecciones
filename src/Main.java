
public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        // Crear contactos
        Contacto c1 = new Contacto(
                "Carlos", "3001234567", "carlos@gmail.com");

        Contacto c2 = new Contacto(
                "Ana", "3101234567", "ana@gmail.com");

        Contacto c3 = new Contacto(
                "Pedro", "3201234567", "pedro@gmail.com");

        // Agregar contactos
        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);
        agenda.agregarContacto(c3);

        // Crear grupos
        agenda.agregarGrupo("Familia");
        agenda.agregarGrupo("Trabajo");

        // Organizar contactos
        agenda.agregarContactoAGrupo("Carlos", "Familia");
        agenda.agregarContactoAGrupo("Ana", "Trabajo");

        // Mostrar contactos
        System.out.println("\nCONTACTOS:");
        agenda.listarContactos();

        // Buscar contacto
        System.out.println("\nBUSCAR CONTACTO:");
        Contacto encontrado = agenda.buscarContacto("Carlos");

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Contacto no encontrado.");
        }

        // Mostrar grupos
        System.out.println("\nGRUPOS:");
        agenda.listarGrupos();

        // Mostrar contactos de un grupo
        System.out.println("\nCONTACTOS DE FAMILIA:");
        agenda.mostrarContactosPorGrupo("Familia");

        // Mostrar historial
        System.out.println("\nHISTORIAL:");
        agenda.listarHistorial();

        // Eliminar contacto
        System.out.println("\nELIMINAR CONTACTO:");
        agenda.eliminarContacto("Carlos");

        // Mostrar historial después de eliminar
        System.out.println("\nHISTORIAL DESPUÉS DE ELIMINAR:");
        agenda.listarHistorial();
    }
}
