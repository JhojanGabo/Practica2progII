package persis4;

public class Nota {
	    private String materia;
	    private double notaFinal;
	    private Estudiante est;

	    public Nota(String materia, double notaFinal, Estudiante est) {
	        this.materia = materia;
	        this.notaFinal = notaFinal;
	        this.est = est;
	    }

	    public double getNotaFinal() { return notaFinal; }
	    public String getMateria() { return materia; }
	    public Estudiante getEstudiante() { return est; }
	    
	    @Override public String toString() { return est + " en " + materia + ": " + notaFinal; }
	}
