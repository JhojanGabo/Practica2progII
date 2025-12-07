package persis4;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.*;
public class ArchiNota {
	    private String nombreArchi = "notas.json";
	    private List<Nota> lista = new ArrayList<>();
	    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    public void agregar(Nota n) {
	        leer();
	        lista.add(n);
	        guardar();
	    }

	    private void guardar() {
	        try (Writer w = new FileWriter(nombreArchi)) { gson.toJson(lista, w); } 
	        catch (IOException e) { e.printStackTrace(); }
	    }

	    private void leer() {
	        try (Reader r = new FileReader(nombreArchi)) {
	            lista = gson.fromJson(r, new TypeToken<List<Nota>>(){}.getType());
	            if (lista == null) lista = new ArrayList<>();
	        } catch (IOException e) { lista = new ArrayList<>(); }
	    }

	    public void promedioTotal() {
	        leer();
	        if (lista.isEmpty()) return;
	        double suma = lista.stream().mapToDouble(Nota::getNotaFinal).sum();
	        System.out.println("Promedio General: " + (suma / lista.size()));
	    }

	    public void mejorNota() {
	        leer();
	        if (lista.isEmpty()) return;
	        double max = lista.stream().mapToDouble(Nota::getNotaFinal).max().orElse(0);
	        lista.stream().filter(n -> n.getNotaFinal() == max).forEach(System.out::println);
	    }

	    public void eliminarPorMateria(String materia) {
	        leer();
	        lista.removeIf(n -> n.getMateria().equalsIgnoreCase(materia));
	        guardar();
	    }
	}