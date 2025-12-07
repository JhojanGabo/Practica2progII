package persis5;
import java.util.ArrayList;
import java.util.List;
public class Farmacia {
	private int sucursal;
    private String direccion;
    // Inicializamos aquí para evitar NullPointerException antes de guardar
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Farmacia(int sucursal, String direccion) {
        this.sucursal = sucursal;
        this.direccion = direccion;
    }

    public void addMedicamento(Medicamento m) { 
        if (medicamentos == null) medicamentos = new ArrayList<>();
        medicamentos.add(m); 
    }

    // Método getter blindado: si Gson lo dejó null, devolvemos una lista nueva
    public List<Medicamento> getMedicamentos() { 
        if (medicamentos == null) {
            medicamentos = new ArrayList<>();
        }
        return medicamentos; 
    }

    public int getSucursal() { return sucursal; }
    public String getDireccion() { return direccion; }
    
    @Override 
    public String toString() { 
        return "Sucursal " + sucursal + " (" + direccion + ")"; 
    }
}