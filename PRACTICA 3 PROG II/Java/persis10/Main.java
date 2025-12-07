package persis10;

public class Main {
    public static void main(String[] args) {
        ArchivoJugador aj = new ArchivoJugador();
        aj.guardarJugador(new Jugador("Slayer123", 55, 9000));
        aj.guardarJugador(new Jugador("NoobMaster", 5, 200));
        
        aj.mostrarTodos();
        aj.buscarPorNombre("Slayer123");
    }
}