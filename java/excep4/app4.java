package excep4;

public class app4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Inventario inv = new Inventario();

		        try {
		            inv.agregarProducto(new Producto("A1","Pan",2,10));
		            inv.agregarProducto(new Producto("A1","Agua",2,5)); // Error código duplicado
		        } catch (Exception e) {
		            System.out.println("ERROR: "+e.getMessage());
		        }

		        try {
		            inv.venderProducto("A1", 20);
		        } catch (Exception e) {
		            System.out.println("ERROR Venta: "+e.getMessage());
		        }

		        inv.mostrarInventario();
		    }
		}
