package persis3;
public class Main {
    public static void main(String[] args) {
    	ProductoManager ap = new ProductoManager();
        ap.guardarProducto(new Producto(1, "Coca Cola", 10.5f));
        ap.guardarProducto(new Producto(2, "Pepsi", 9.0f));
        ap.buscarProducto(1);
        ap.promedioPrecios();
        ap.mostrarMasCaro();
    }
}

	
