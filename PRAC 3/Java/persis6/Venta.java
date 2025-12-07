package persis6;

public class Venta {
	    private int id;
	    private int libroCodigo;
	    private int cantidad;

	    public Venta(int id, int libroCodigo, int cantidad){
	        this.id = id;
	        this.libroCodigo = libroCodigo;
	        this.cantidad = cantidad;
	    }

	    public int getLibroCodigo(){ return libroCodigo; }
	    public int getCantidad(){ return cantidad; }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
