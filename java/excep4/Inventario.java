package excep4;
import java.util.ArrayList;
import java.util.List;
public class Inventario {
	    private List<Producto> productos = new ArrayList<>();

	    public void agregarProducto(Producto p) throws Exception {
	        if (p.getStock() < 0 || p.getCodigo().equals(""))
	            throw new Exception("Código vacío o stock negativo.");

	        for (Producto pr : productos)
	            if (pr.getCodigo().equals(p.getCodigo()))
	                throw new Exception("Código duplicado.");

	        productos.add(p);
	    }

	    public Producto buscarProducto(String codigo)
	            throws ProductoNoEncontradoException {

	        for (Producto p : productos)
	            if (p.getCodigo().equals(codigo))
	                return p;

	        throw new ProductoNoEncontradoException("No existe el producto con código " + codigo);
	    }

	    public void venderProducto(String codigo, int cantidad)
	            throws ProductoNoEncontradoException, StockInsuficienteException {

	        Producto p = buscarProducto(codigo);

	        if (p.getStock() < cantidad)
	            throw new StockInsuficienteException("Stock insuficiente.");

	        p.reducirStock(cantidad);
	    }

	    public void mostrarInventario(){
	        for (Producto p: productos)
	            p.mostrarProducto();
	    }
}
