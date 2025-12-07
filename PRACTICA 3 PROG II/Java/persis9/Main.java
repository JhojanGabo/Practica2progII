package persis9;

public class Main {
    public static void main(String[] args) {
        ArchZoo az = new ArchZoo();
        Zoologico z1 = new Zoologico(1, "Vesty Pakos");
        z1.animales.add(new Animal("Mamifero", "Oso", 2));
        az.agregarZoo(z1);
        az.listarMayorVariedad();
    }
}