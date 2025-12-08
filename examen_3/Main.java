package examen_3;

public class Main {
	
    public static void main(String[] args) {
        Consultorio sistema = new Consultorio();

        sistema.incisoA_AltaDatos();
        
        sistema.incisoB_BajaMedico("Maria", "Perez");

        sistema.incisoC_CambiarFechasFestivas();
    }
}