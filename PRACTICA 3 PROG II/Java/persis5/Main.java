package persis5;
public class Main {
    public static void main(String[] args) {
        try {
            ArchFarmacia af = new ArchFarmacia();
            
            Farmacia f1 = new Farmacia(1, "Av. 6 de Marzo (El Alto)");
            f1.addMedicamento(new Medicamento("Tapsin", "Antigripal", 5.50));
            f1.addMedicamento(new Medicamento("Ibuprofeno", "Analgesico", 2.00));
            
            Farmacia f2 = new Farmacia(2, "Prado (La Paz)");
            f2.addMedicamento(new Medicamento("Paracetamol", "Analgesico", 1.50));
            
            System.out.println("Guardando farmacias...");
            af.registrar(f1);
            af.registrar(f2);
            
            af.mostrarUbicacionMedicamento("Tapsin");
            
            af.moverMedicamento("Analgesico", 1, 2);
            
            af.buscarPorTipo("Analgesico");
            
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
	
