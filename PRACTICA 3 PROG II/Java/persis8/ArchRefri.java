package persis8;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ArchRefri {
    private String file = "refri.json";
    private Gson gson = new Gson();

    private List<Alimento> leer() {
        try (FileReader r = new FileReader(file)) {
            List<Alimento> l = gson.fromJson(r, new TypeToken<List<Alimento>>(){}.getType());
            return l != null ? l : new ArrayList<>();
        } catch (IOException e) { return new ArrayList<>(); }
    }
    private void guardar(List<Alimento> l) {
        try (FileWriter w = new FileWriter(file)) { gson.toJson(l, w); } catch (IOException e) {}
    }

    public void agregar(Alimento a) { List<Alimento> l = leer(); l.add(a); guardar(l); }
    
    public void eliminarCantidadCero() {
        List<Alimento> l = leer();
        l.removeIf(a -> a.cantidad == 0);
        guardar(l);
    }

    public void mostrarCaducados(String fechaActual) {
        leer().stream().filter(a -> a.estaVencido(fechaActual)).forEach(System.out::println);
    }

    public void maxCantidad() {
        leer().stream().max(Comparator.comparingInt(a -> a.cantidad)).ifPresent(System.out::println);
    }
}
