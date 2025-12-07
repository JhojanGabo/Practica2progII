package persis5;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
	 public class ArchFarmacia {
		 private String ruta = "farmacias.json";
		    private List<Farmacia> lista = new ArrayList<>();
		    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

		    // Guardar la lista actual en disco
		    public void guardar() {
		        try (Writer w = new FileWriter(ruta)) { 
		            gson.toJson(lista, w); 
		        } catch(IOException e) {
		            System.err.println("Error al guardar: " + e.getMessage());
		        }
		    }
		    
		    // Leer del disco y cargar en memoria
		    public void leer() {
		        File f = new File(ruta);
		        if (!f.exists()) {
		            lista = new ArrayList<>();
		            return;
		        }
		        try (Reader r = new FileReader(ruta)) {
		            lista = gson.fromJson(r, new TypeToken<List<Farmacia>>(){}.getType());
		            if (lista == null) lista = new ArrayList<>();
		        } catch(IOException e) { 
		            lista = new ArrayList<>(); 
		        }
		    }
		    
		    // a) Agregar Farmacia (CRUD: Crear)
		    public void registrar(Farmacia f) {
		        leer();
		        lista.add(f);
		        guardar();
		    }

		    // b) Mostrar sucursal de un medicamento (Tapsin)
		    public void mostrarUbicacionMedicamento(String nombreMed) {
		        leer();
		        boolean encontrado = false;
		        System.out.println("--- Buscando: " + nombreMed + " ---");
		        for (Farmacia f : lista) {
		            for (Medicamento m : f.getMedicamentos()) {
		                if (m.getNombre().equalsIgnoreCase(nombreMed)) {
		                    System.out.println("Encontrado en: " + f);
		                    encontrado = true;
		                }
		            }
		        }
		        if (!encontrado) System.out.println("No se encontró el medicamento.");
		    }

		    // c) Buscar por tipo
		    public void buscarPorTipo(String tipo) {
		        leer();
		        System.out.println("--- Medicamentos tipo: " + tipo + " ---");
		        for (Farmacia f : lista) {
		            for (Medicamento m : f.getMedicamentos()) {
		                if (m.getTipo().equalsIgnoreCase(tipo)) {
		                    System.out.println(m + " disponible en " + f.getDireccion());
		                }
		            }
		        }
		    }

		    // d) Ordenar farmacias por dirección
		    public void ordenarPorDireccion() {
		        leer();
		        lista.sort(Comparator.comparing(Farmacia::getDireccion));
		        guardar();
		        System.out.println("--- Farmacias ordenadas por dirección ---");
		    }

		    // e) Mover medicamentos
		    public void moverMedicamento(String tipo, int sucOrigen, int sucDestino) {
		        leer();
		        Farmacia origen = null;
		        Farmacia destino = null;

		        // 1. Buscar las farmacias
		        for (Farmacia f : lista) {
		            if (f.getSucursal() == sucOrigen) origen = f;
		            if (f.getSucursal() == sucDestino) destino = f;
		        }

		        // 2. Validar que existan
		        if (origen == null || destino == null) {
		            System.out.println("Error: Una de las sucursales no existe.");
		            return;
		        }

		        // 3. Mover usando Iterator para evitar ConcurrentModificationException
		        System.out.println("--- Moviendo medicamentos tipo '" + tipo + "' de Sucursal " + sucOrigen + " a " + sucDestino + " ---");
		        Iterator<Medicamento> it = origen.getMedicamentos().iterator();
		        int cont = 0;
		        
		        while (it.hasNext()) {
		            Medicamento m = it.next();
		            if (m.getTipo().equalsIgnoreCase(tipo)) {
		                destino.addMedicamento(m); // Agregar al destino
		                it.remove();               // Eliminar del origen de forma segura
		                cont++;
		            }
		        }
		        
		        if (cont > 0) {
		            guardar(); // Guardar cambios solo si hubo movimientos
		            System.out.println("Se movieron " + cont + " medicamentos con éxito.");
		        } else {
		            System.out.println("No se encontraron medicamentos de ese tipo en la sucursal origen.");
		        }
		    }
		}