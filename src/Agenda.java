import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Agenda {

    // Contactos ordenados alfabéticamente por nombre
    private Map<String, Contacto> contactos = new TreeMap<>();

    // Grupos únicos y ordenados alfabéticamente
    private Set<String> grupos = new TreeSet<>();

    // Relación entre grupos y nombres de contactos
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();

    // Historial en orden de inserción
    private List<Contacto> historial = new ArrayList<>();


    // Agregar un contacto
    public void agregarContacto(Contacto c) {

        if (!contactos.containsKey(c.getNombre())) {
            contactos.put(c.getNombre(), c);
            historial.add(c);

            System.out.println("Contacto agregado correctamente.");
        } else {
            System.out.println("Contacto existente.");
        }
    }


    // Buscar un contacto por nombre
    public Contacto buscarContacto(String nombre) {

        return contactos.get(nombre);
    }


    // Eliminar un contacto por nombre
    public void eliminarContacto(String nombre) {

        if (contactos.containsKey(nombre)) {

            contactos.remove(nombre);

            // Eliminar el contacto de los grupos
            for (Set<String> nombres : contactosPorGrupo.values()) {
                nombres.remove(nombre);
            }

            System.out.println("Contacto eliminado correctamente.");

        } else {
            System.out.println("El contacto no existe.");
        }
    }


    // Listar contactos en orden alfabético
    public void listarContactos() {

        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }


    // Listar historial en orden de inserción
    public void listarHistorial() {

        for (Contacto c : historial) {
            System.out.println(c);
        }
    }


    // Agregar un grupo
    public void agregarGrupo(String nombreGrupo) {

        if (grupos.add(nombreGrupo)) {

            contactosPorGrupo.put(nombreGrupo, new TreeSet<>());

            System.out.println("Grupo agregado correctamente.");

        } else {
            System.out.println("El grupo ya existe.");
        }
    }


    // Agregar un contacto a un grupo
    public void agregarContactoAGrupo(
            String nombreContacto, String nombreGrupo) {

        if (contactos.containsKey(nombreContacto)
                && grupos.contains(nombreGrupo)) {

            contactosPorGrupo.get(nombreGrupo).add(nombreContacto);

            System.out.println("Contacto agregado al grupo.");

        } else {
            System.out.println(
                    "El contacto o el grupo no existen.");
        }
    }


    // Listar grupos en orden alfabético
    public void listarGrupos() {

        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }


    // Mostrar los contactos de un grupo
    public void mostrarContactosPorGrupo(String nombreGrupo) {

        if (grupos.contains(nombreGrupo)) {

            Set<String> nombres =
                    contactosPorGrupo.get(nombreGrupo);

            for (String nombre : nombres) {

                Contacto c = contactos.get(nombre);

                if (c != null) {
                    System.out.println(c);
                }
            }

        } else {
            System.out.println("El grupo no existe.");
        }
    }
}

