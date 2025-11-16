package excep6;

public class app6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        CuentaBancaria c = new CuentaBancaria("12345","Juan Perez",1000);

		        c.mostrarInfo();

		        try {
		            c.depositar(200);
		            c.depositar(-50);
		        } catch (Exception e){
		            System.out.println("ERROR Depósito: "+e.getMessage());
		        }

		        try {
		            c.retirar(500);
		            c.retirar(2000);
		        } catch (FondosInsuficientesException e){
		            System.out.println("ERROR Retiro: "+e.getMessage());
		        }

		        c.mostrarInfo();
		    }
		}
