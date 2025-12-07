package persis9;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
public class ArchZoo {
	private String file = "zoos.json";
    private Gson gson = new Gson();

    private List<Zoologico> leer() {
        try (FileReader r = new FileReader(file)) {
            List<Zoologico> l = gson.fromJson(r, new TypeToken<List<Zoologico>>(){}.getType());
            return l != null ? l : new ArrayList<>();
        } catch (IOException e) { return new ArrayList<>(); }
    }
    private void guardar(List<Zoologico> l) {
        try (FileWriter w = new FileWriter(file)) { gson.toJson(l, w); } catch (IOException e) {}
    }

    public void agregarZoo(Zoologico z) { List<Zoologico> l = leer(); l.add(z); guardar(l); }

    public void listarMayorVariedad() {
        leer().stream().max(Comparator.comparingInt(z -> z.animales.size()))
            .ifPresent(z -> System.out.println("Mayor variedad: " + z.nombre));
    }

    public void eliminarVacios() {
        List<Zoologico> l = leer();
        l.removeIf(z -> z.animales.isEmpty());
        guardar(l);
    }
    
    public void mostrarEspecie(String especie) {
        leer().forEach(z -> z.animales.stream()
            .filter(a -> a.especie.equalsIgnoreCase(especie))
            .forEach(a -> System.out.println(a.nombre + " en " + z.nombre)));
    }
}