package excep2;

public class Calculadora {
	    public static int sumar(int a, int b) {
	        return a + b;
	    }

	    public static int restar(int a, int b) {
	        return a - b;
	    }

	    public static int multiplicar(int a, int b) {
	        return a * b;
	    }

	    public static int dividir(int a, int b) {
	        if (b == 0)
	            throw new ArithmeticException("No se puede dividir entre 0.");
	        return a / b;
	    }

	    public static int convertir(String txt) throws NumeroInvalidoException {
	        try {
	            return Integer.parseInt(txt);
	        } catch (Exception e) {
	            throw new NumeroInvalidoException("El valor '" + txt + "' no es numérico.");
	        }
	    }

}
