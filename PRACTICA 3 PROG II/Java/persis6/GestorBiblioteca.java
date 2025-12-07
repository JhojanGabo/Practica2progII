package persis6;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
	public class GestorBiblioteca {
		private String ruta = "biblioteca.json";
	    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    // Contenedor que agrupa todas las listas para guardarlas y cargarlas juntas
	    private static class DataContainer {
	        List<Libro> libros;
	        List<Cliente> clientes;
	        List<Prestamo> prestamos;
	    }

	    private List<Libro> libros = new ArrayList<>();
	    private List<Cliente> clientes = new ArrayList<>();
	    private List<Prestamo> prestamos = new ArrayList<>();

	    // Guarda el estado actual de las 3 listas en el JSON
	    private void guardar() {
	        DataContainer data = new DataContainer();
	        data.libros = this.libros;
	        data.clientes = this.clientes;
	        data.prestamos = this.prestamos;
	        
	        try (Writer w = new FileWriter(ruta)) {
	            gson.toJson(data, w);
	        } catch (IOException e) {
	            System.err.println("Error al guardar datos: " + e.getMessage());
	        }
	    }

	    // Lee el JSON y carga las 3 listas, manejando el caso de archivo inexistente o vacío
	    private void leer() {
	        File f = new File(ruta);
	        if (!f.exists() || f.length() == 0) {
	            this.libros = new ArrayList<>();
	            this.clientes = new ArrayList<>();
	            this.prestamos = new ArrayList<>();
	            return;
	        }

	        try (Reader r = new FileReader(ruta)) {
	            DataContainer data = gson.fromJson(r, DataContainer.class);
	            
	            if (data != null) {
	                // Blindaje contra posibles valores null si el JSON está incompleto
	                this.libros = data.libros != null ? data.libros : new ArrayList<>();
	                this.clientes = data.clientes != null ? data.clientes : new ArrayList<>();
	                this.prestamos = data.prestamos != null ? data.prestamos : new ArrayList<>();
	            } else {
	                this.libros = new ArrayList<>();
	                this.clientes = new ArrayList<>();
	                this.prestamos = new ArrayList<>();
	            }
	        } catch (IOException e) { 
	             System.err.println("Error al leer datos: " + e.getMessage());
	        }
	    }
	    
	    // --- Métodos de CRUD para agregar datos ---

	    public void agregarLibro(Libro l) {
	        leer();
	        libros.add(l);
	        guardar();
	    }
	    
	    public void agregarCliente(Cliente c) {
	        leer();
	        clientes.add(c);
	        guardar();
	    }
	    
	    public void agregarPrestamo(Prestamo p) {
	        leer();
	        prestamos.add(p);
	        guardar();
	    }

	    // --- Métodos de Requerimiento ---

	    // 1. Libros por rango precio
	    public void listarLibrosRango(double x, double y) {
	        leer();
	        System.out.println("\n--- Libros en rango de " + x + " a " + y + " Bs ---");
	        libros.stream()
	              .filter(l -> l.getPrecio() >= x && l.getPrecio() <= y)
	              .forEach(System.out::println);
	    }

	    // 2. Ingreso por libro
	    public void ingresoTotalLibro(String cod) {
	        leer();
	        double precio = libros.stream()
	                              .filter(l -> l.getCodigo().equals(cod))
	                              .findFirst()
	                              .map(Libro::getPrecio)
	                              .orElse(0.0);
	                              
	        int totalPrestado = prestamos.stream()
	                                     .filter(p -> p.getCodLibro().equals(cod))
	                                     .mapToInt(Prestamo::getCantidad)
	                                     .sum();
	                                     
	        System.out.println("\n--- Ingreso Total por Libro " + cod + " ---");
	        System.out.println("Ingreso total: " + (precio * totalPrestado) + " Bs");
	    }

	    // 3. Libros no vendidos (no prestados)
	    public void librosNuncaPrestados() {
	        leer();
	        Set<String> prestados = prestamos.stream()
	                                         .map(Prestamo::getCodLibro)
	                                         .collect(Collectors.toSet());
	                                         
	        System.out.println("\n--- Libros Nunca Prestados ---");
	        libros.stream()
	              .filter(l -> !prestados.contains(l.getCodigo()))
	              .forEach(System.out::println);
	    }

	    // 4. Clientes que compraron X
	    public void clientesDeLibro(String codLibro) {
	        leer();
	        List<Integer> cis = prestamos.stream()
	                                     .filter(p -> p.getCodLibro().equals(codLibro))
	                                     .map(Prestamo::getCiCliente)
	                                     .distinct()
	                                     .collect(Collectors.toList());
	                                     
	        System.out.println("\n--- Clientes que llevaron Libro " + codLibro + " ---");
	        clientes.stream()
	                .filter(c -> cis.contains(c.getCi()))
	                .forEach(System.out::println);
	    }

	    // 5. Libro más prestado
	    public void libroMasPrestado() {
	        leer();
	        if (prestamos.isEmpty()) {
	            System.out.println("\nNo hay préstamos registrados.");
	            return;
	        }
	        
	        Map<String, Integer> conteo = new HashMap<>();
	        for (Prestamo p : prestamos) {
	            conteo.put(p.getCodLibro(), conteo.getOrDefault(p.getCodLibro(), 0) + p.getCantidad());
	        }
	        
	        conteo.entrySet().stream()
	              .max(Map.Entry.comparingByValue())
	              .ifPresent(e -> {
	                  Libro l = libros.stream().filter(lb -> lb.getCodigo().equals(e.getKey())).findFirst().orElse(null);
	                  System.out.println("\n--- Libro Más Prestado ---");
	                  System.out.println(l != null ? l.titulo : "Cod: " + e.getKey() + " (no encontrado)");
	                  System.out.println("Veces prestado/Cantidad: " + e.getValue());
	              });
	    }
	}