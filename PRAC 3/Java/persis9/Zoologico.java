package persis9;
import java.util.ArrayList;
import java.util.List;
public class Zoologico {
	int id;
    String nombre;
    List<Animal> animales = new ArrayList<>();
    public Zoologico(int i, String n) { id = i; nombre = n; }
    @Override public String toString() { return nombre + " Animales: " + animales.size(); }
}