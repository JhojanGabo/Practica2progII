package persis2;
public class Main {
    public static void main(String[] args) {
    	TrabajadorManager arch = new TrabajadorManager();
        arch.guardarTrabajador(new Trabajador("Juan", 123, 2500));
        arch.guardarTrabajador(new Trabajador("Ana", 456, 4000));
        arch.aumentarSalario(123, 500);
        arch.ordenarPorSalario();
        arch.buscarMayorSalario();
    }
}