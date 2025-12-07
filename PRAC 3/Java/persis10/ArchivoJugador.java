package persis10;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
public class ArchivoJugador {
	private String nombreArchivo = "jugadores.txt"; // Usando .txt como pide el enunciado, pero formato JSON dentro
    private List<Jugador> lista = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardarJugador(Jugador j) {
        leer();
        lista.add(j);
        try (Writer writer = new FileWriter(nombreArchivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodos() {
        leer();
        if (lista.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("--- Lista de Jugadores ---");
            for (Jugador j : lista) {
                System.out.println(j);
            }
        }
    }

    public void buscarPorNombre(String nombre) {
        leer();
        boolean encontrado = false;
        for (Jugador j : lista) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + j);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) System.out.println("Jugador " + nombre + " no encontrado.");
    }

    private void leer() {
        try (Reader reader = new FileReader(nombreArchivo)) {
            lista = gson.fromJson(reader, new TypeToken<List<Jugador>>(){}.getType());
            if (lista == null) lista = new ArrayList<>();
        } catch (IOException e) {
            lista = new ArrayList<>();
        }
    }
}