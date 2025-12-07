package persis3;
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
public class ProductoManager {
	    private String nomA = "productos.json";
	    private List<Producto> lista = new ArrayList<>();
	    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    public void crearArchivo() {
	        guardar();
	    }

	    public void guardarProducto(Producto p) {
	        leer();
	        lista.add(p);
	        guardar();
	    }

	    private void guardar() {
	        try (Writer writer = new FileWriter(nomA)) {
	            gson.toJson(lista, writer);
	        } catch (IOException e) { e.printStackTrace(); }
	    }

	    private void leer() {
	        try (Reader reader = new FileReader(nomA)) {
	            lista = gson.fromJson(reader, new TypeToken<List<Producto>>(){}.getType());
	            if (lista == null) lista = new ArrayList<>();
	        } catch (IOException e) { lista = new ArrayList<>(); }
	    }

	    public void buscarProducto(int c) {
	        leer();
	        for (Producto p : lista) {
	            if (p.getCodigo() == c) {
	                System.out.println(p);
	                return;
	            }
	        }
	        System.out.println("No encontrado");
	    }

	    public void promedioPrecios() {
	        leer();
	        if (lista.isEmpty()) return;
	        double sum = 0;
	        for (Producto p : lista) sum += p.getPrecio();
	        System.out.println("Promedio: " + (sum / lista.size()));
	    }

	    public void mostrarMasCaro() {
	        leer();
	        if (lista.isEmpty()) return;
	        Producto caro = Collections.max(lista, Comparator.comparingDouble(Producto::getPrecio));
	        System.out.println("Más caro: " + caro);
	    }
	}
