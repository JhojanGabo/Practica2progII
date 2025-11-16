package excep4;

public class Producto {
	    private String codigo;
	    private String nombre;
	    private double precio;
	    private int stock;

	    public Producto(String c, String n, double p, int s) {
	        codigo=c; nombre=n; precio=p; stock=s;
	    }

	    public String getCodigo(){ return codigo; }

	    public void reducirStock(int cant) {
	        stock -= cant;
	    }

	    public int getStock(){ return stock; }

	    public void mostrarProducto() {
	        System.out.println(codigo+" | "+nombre+" | Precio: "+precio+" | Stock: "+stock);
	    }
}
