package persis2;
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
public class TrabajadorManager {
	
	    private String nombreArch = "trabajadores.json";
	    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    private List<Trabajador> trabajadores;

	    public TrabajadorManager() {
	        trabajadores = new ArrayList<>();
	        leer(); 
	    }

	    public void crearArchivo() {
	        guardarEnDisco();
	    }

	    public void guardarTrabajador(Trabajador t) {
	        trabajadores.add(t);
	        guardarEnDisco();
	    }

	    private void guardarEnDisco() {
	        try (Writer writer = new FileWriter(nombreArch)) {
	            gson.toJson(trabajadores, writer);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void leer() {
	        try (Reader reader = new FileReader(nombreArch)) {
	            trabajadores = gson.fromJson(reader, new TypeToken<List<Trabajador>>(){}.getType());
	            if (trabajadores == null) trabajadores = new ArrayList<>();
	        } catch (IOException e) {
	            trabajadores = new ArrayList<>();
	        }
	    }

	    public void aumentarSalario(int carnet, double aumento) {
	        for (Trabajador t : trabajadores) {
	            if (t.getCarnet() == carnet) {
	                t.setSalario(t.getSalario() + aumento);
	                break;
	            }
	        }
	        guardarEnDisco();
	    }

	    public void buscarMayorSalario() {
	        if (trabajadores.isEmpty()) return;
	        Trabajador max = Collections.max(trabajadores, Comparator.comparingDouble(Trabajador::getSalario));
	        System.out.println("Mayor salario: " + max);
	    }

	    public void ordenarPorSalario() {
	        trabajadores.sort(Comparator.comparingDouble(Trabajador::getSalario));
	        guardarEnDisco();
	    }
	}
