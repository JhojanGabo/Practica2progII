package ejer10;
import java.util.ArrayList;
import java.util.List;
public class Charla {
	    private String tema;
	    private Speaker speaker;
	    private List<Participante> participantes;

	    public Charla(String tema, Speaker speaker) {
	        this.tema = tema;
	        this.speaker = speaker;
	        this.participantes = new ArrayList<>();
	    }

	    public void addParticipante(Participante p) {
	        participantes.add(p);
	    }

	    public int cantidadParticipantes() {
	        return participantes.size();
	    }

	    public Speaker getSpeaker() { return speaker; }
	    public List<Participante> getParticipantes() { return participantes; }

	    public void mostrarCharla() {
	        System.out.println("Tema: " + tema);
	        speaker.mostrarSpeaker();
	        System.out.println("Participantes:");
	        for (Participante p : participantes) {
	            p.mostrarParticipante();
	        }
	    }
}
