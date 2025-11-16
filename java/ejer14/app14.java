package ejer14;

public class app14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        Empresa miEmpresa = new Empresa("Tecnologías Futuras");

	        miEmpresa.agregarEmpleado(new Empleado("Carlos Ruiz", "Desarrollador Senior", 5000));
	        miEmpresa.agregarEmpleado(new Empleado("Beatriz Jara", "Gerente de Proyectos", 7000));
	        miEmpresa.agregarEmpleado(new Empleado("David Kim", "Desarrollador Junior", 3000));

	        miEmpresa.mostrarInformacion();

	        System.out.println("Promedio Salarial: " + miEmpresa.calcularPromedioSalarial());
	        System.out.println();

	        miEmpresa.listarSalariosMayoresA(4000);
	        System.out.println();

	        System.out.println("Buscando a 'Beatriz Jara':");
	        Empleado e = miEmpresa.buscarEmpleado("Beatriz Jara");
	        if (e != null) {
	            e.mostrar();
	        }

	        System.out.println();
	        miEmpresa.eliminarEmpleado("David Kim");
	        miEmpresa.mostrarInformacion();
	    }
}
