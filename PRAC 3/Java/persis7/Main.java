package persis7;

public class Main {
    public static void main(String[] args) {
        ArchiNiño an = new ArchiNiño();
        an.agregar(new Niño("Carlitos", 999, 10, 35, 1.40));
        an.agregar(new Niño("Maria", 888, 11, 40, 1.55));
        an.promedioEdad();
        an.verificarSalud();
        an.mostrarMasAlto();
    }
}