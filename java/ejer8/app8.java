package ejer8;

public class app8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        SistemaEntrada sistema = new SistemaEntrada();

		        Facultad fcpn = new Facultad("Ciencias Puras y Naturales");
		        Facultad ing = new Facultad("Ingeniería");
		        
		        sistema.addFacultad(fcpn);
		        sistema.addFacultad(ing);

		        Bailarin b1 = new Bailarin("Juan Perez", 20, "111");
		        Bailarin b2 = new Bailarin("Ana Lopez", 22, "222");
		        Bailarin b3 = new Bailarin("Luis Cruz", 21, "333");
		        Bailarin b4 = new Bailarin("Maria Soliz", 19, "444");

		        Fraternidad info = new Fraternidad("Caporales de Informática", b1);
		        Fraternidad arqui = new Fraternidad("Tinkus de Arquitectura", b3); 

		        fcpn.addFraternidad(info);
		        ing.addFraternidad(arqui); 

		        sistema.registrarBailarin(b1, info); 
		        sistema.registrarBailarin(b2, info);
		        
		        sistema.registrarBailarin(b3, arqui);
		        sistema.registrarBailarin(b4, arqui);

		        System.out.println("\n--- Intentando registrar duplicado ---");
		        Bailarin b5_duplicado = new Bailarin("Juan Perez Tramposo", 25, "111");
		        sistema.registrarBailarin(b5_duplicado, arqui);
		        
		        System.out.println("\n--- Mostrando participantes ---");
		        sistema.mostrarBailarinesPorFacultad("Ciencias Puras y Naturales");
		        
		        System.out.println("\n--- Mostrando edades ---");
		        sistema.mostrarEdadesParticipantes();
		    }
}
