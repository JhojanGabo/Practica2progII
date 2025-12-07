package persis5;
public class Main {
    public static void main(String[] args) {
        try {
            ArchFarmacia af = new ArchFarmacia();
            
            // 1. Crear datos de prueba
            Farmacia f1 = new Farmacia(1, "Av. 6 de Marzo (El Alto)");
            f1.addMedicamento(new Medicamento("Tapsin", "Antigripal", 5.50));
            f1.addMedicamento(new Medicamento("Ibuprofeno", "Analgesico", 2.00));
            
            Farmacia f2 = new Farmacia(2, "Prado (La Paz)");
            f2.addMedicamento(new Medicamento("Paracetamol", "Analgesico", 1.50));
            
            // 2. Registrar (esto creará el archivo JSON)
            System.out.println("Guardando farmacias...");
            af.registrar(f1);
            af.registrar(f2);
            
            // 3. Probar métodos
            af.mostrarUbicacionMedicamento("Tapsin");
            
            // 4. Mover "Analgesico" de la Sucursal 1 a la 2 (Debería mover el Ibuprofeno)
            af.moverMedicamento("Analgesico", 1, 2);
            
            // 5. Verificar resultado buscando en destino
            af.buscarPorTipo("Analgesico");
            
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
	
