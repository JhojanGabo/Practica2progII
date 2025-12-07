package persis1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.*;
public class CharangoManager {
    private String ruta = "charangos.json";
    private List<Charango> lista = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void adicionar(Charango c) {
        lista.add(c);
    }

    public void guardar() {
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leer() {
        try (Reader reader = new FileReader(ruta)) {
            lista = gson.fromJson(reader, new TypeToken<List<Charango>>(){}.getType());
        } catch (FileNotFoundException e) {
            lista = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDañados() {
        lista.removeIf(c -> c.contarCuerdasFalse() > 6);
        guardar();
    }

    public void listarPorMaterial(String x) {
        for (Charango c : lista) {
            if (c.getMaterial().equalsIgnoreCase(x)) {
                System.out.println(c);
            }
        }
    }

    public void buscarDiezCuerdas() {
        for (Charango c : lista) {
            if (c.getNroCuerdas() == 10) {
                System.out.println(c);
            }
        }
    }

    public void ordenarPorMaterial() {
        lista.sort(Comparator.comparing(Charango::getMaterial));
        guardar();
    }
}
