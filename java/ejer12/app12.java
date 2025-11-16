package ejer12;

public class app12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Doctor dr1 = new Doctor("Juan Perez", "Cardiología");
		        Doctor dr2 = new Doctor("Ana Gomez", "Pediatría");
		        Doctor dr3 = new Doctor("Luis Soliz", "Neurología");

		        Hospital hospitalA = new Hospital("Hospital General");
		        Hospital hospitalB = new Hospital("Clínica del Sur");

		        hospitalA.asignarDoctor(dr1);
		        hospitalA.asignarDoctor(dr2);

		        hospitalB.asignarDoctor(dr3);
		        hospitalB.asignarDoctor(dr1); 

		        hospitalA.mostrarDoctores();
		        System.out.println();
		        hospitalB.mostrarDoctores();
	}

}
