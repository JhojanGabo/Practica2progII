package ejer4;

public class app4 {
    public static void main(String[] args) {
        ropero miRopero = new ropero("Madera");

        miRopero.adicionarPrenda(new Ropa("Camisa", "Algodon"));
        miRopero.adicionarPrenda(new Ropa("Pantalon", "Jean"));
        miRopero.adicionarPrenda(new Ropa("Chamarra", "Cuero"));
        miRopero.adicionarPrenda(new Ropa("Camisa", "Seda"));

        miRopero.mostrarTodo();

        miRopero.mostrarPrendas("Camisa", "Algodon");

        System.out.println("\nEliminando prendas de Algodon o tipo Chamarra");
        miRopero.eliminarPrenda("Chamarra", "Algodon");

        miRopero.mostrarTodo();
    }
}



