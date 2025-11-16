package excep6;

public class CuentaBancaria {
	    private String numeroCuenta;
	    private String titular;
	    private double saldo;

	    public CuentaBancaria(String n, String t, double s){
	        numeroCuenta=n;
	        titular=t;
	        saldo=s;
	    }

	    public void depositar(double monto){
	        if(monto <= 0)
	            throw new IllegalArgumentException("Monto inválido");
	        saldo += monto;
	    }

	    public void retirar(double monto) throws FondosInsuficientesException {
	        if(monto > saldo)
	            throw new FondosInsuficientesException("Fondos insuficientes");
	        saldo -= monto;
	    }

	    public void mostrarInfo(){
	        System.out.println(numeroCuenta+" | "+titular+" | Saldo: "+saldo);
	    }
}
