package excep2;

public class app2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        try {
		            System.out.println("Suma: " + Calculadora.sumar(3, 4));
		            System.out.println("División: " + Calculadora.dividir(10, 0));
		        } catch (Exception e) {
		            System.out.println("ERROR: " + e.getMessage());
		        }

		        try {
		            int valor = Calculadora.convertir("hola");
		            System.out.println("Valor convertido: " + valor);
		        } catch (NumeroInvalidoException e) {
		            System.out.println("ERROR Conversión: " + e.getMessage());
		        }
	}

}
