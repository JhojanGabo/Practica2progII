package persis8;
public class Main {
    public static void main(String[] args) {
        ArchRefri ar = new ArchRefri();
        ar.agregar(new Alimento("Leche", "2025-01-01", 2));
        ar.agregar(new Alimento("Huevo", "2024-12-01", 0));
        
        System.out.println("Caducados al 2025-02-01:");
        ar.mostrarCaducados("2025-02-01");
        ar.eliminarCantidadCero();
    }
}

