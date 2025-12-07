package persis1;
import java.util.Arrays;
public class Charango {
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas;

    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = cuerdas;
    }

    public String getMaterial() { return material; }
    public int getNroCuerdas() { return nroCuerdas; }
    
    public int contarCuerdasFalse() {
        int c = 0;
        for (boolean b : cuerdas) if (!b) c++;
        return c;
    }

    @Override
    public String toString() {
        return "Charango{material='" + material + "', nro=" + nroCuerdas + "}";
    }
}

