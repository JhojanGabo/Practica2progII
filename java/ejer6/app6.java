package ejer6;

public class app6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Farmacia f = new Farmacia("Mi Salud", "Av. 6 de Marzo");

		        f.addMedicamento(new Medicamento("Ibuprofeno", 5.0, 20));
		        f.addMedicamento(new Medicamento("Paracetamol", 3.0, 40));

		        f.addProveedor(new Proveedor("Droguería Andina", "7896541"));
		        f.addProveedor(new Proveedor("Farmacorp Dist", "7772222"));

		        f.mostrarFarmacia();
		    }
		}

