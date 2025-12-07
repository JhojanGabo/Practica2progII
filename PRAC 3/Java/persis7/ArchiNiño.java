package persis7;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
public class ArchiNiño {
    private String ruta = "ninos.json";
    private List<Niño> lista = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void agregar(Niño n) {
        leer();
        lista.add(n);
        guardar();
    }
    
    private void leer() {
        try (Reader r = new FileReader(ruta)) {
            lista = gson.fromJson(r, new TypeToken<List<Niño>>(){}.getType());
            if(lista==null) lista=new ArrayList<>();
        } catch(Exception e){ lista=new ArrayList<>(); }
    }
    
    private void guardar() {
        try(Writer w = new FileWriter(ruta)){ gson.toJson(lista, w); } catch(Exception e){}
    }

    public void verificarSalud() {
        leer();
        System.out.println("Niños con peso inadecuado (IMC simple simulado):");
        for(Niño n : lista) {
            double imc = n.peso / (n.talla * n.talla);
            if(imc < 18.5 || imc > 25) System.out.println(n.nombre + " (IMC: " + String.format("%.2f", imc) + ")");
        }
    }

    public void promedioEdad() {
        leer();
        double avg = lista.stream().mapToInt(n->n.edad).average().orElse(0);
        System.out.println("Edad promedio: " + avg);
    }

    public void buscarCarnet(int ci) {
        leer();
        lista.stream().filter(n->n.carnet == ci).findFirst().ifPresent(System.out::println);
    }

    public void mostrarMasAlto() {
        leer();
        lista.stream().max(Comparator.comparingDouble(n->n.talla)).ifPresent(n -> System.out.println("Más alto: " + n));
    }
}