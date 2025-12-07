package persis4;
public class Main {
    public static void main(String[] args) {
        ArchiNota an = new ArchiNota();
        Estudiante e1 = new Estudiante(101, "Luis", "Perez", "A", 20);
        an.agregar(new Nota("INF-121", 85, e1));
        an.agregar(new Nota("INF-131", 45, e1));
        an.promedioTotal();
        an.mejorNota();
        an.eliminarPorMateria("INF-131");
    }
}

