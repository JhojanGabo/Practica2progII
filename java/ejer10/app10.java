package ejer10;

public class app10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Evento evento = new Evento("Tech Talks 2025");

		        Speaker s1 = new Speaker("Juan", "Perez", "123");
		        Speaker s2 = new Speaker("Maria", "Lopez", "456");

		        Charla c1 = new Charla("Java Avanzado", s1);
		        c1.addParticipante(new Participante("Ana", "Quispe", 20));
		        c1.addParticipante(new Participante("Luis", "Mamani", 22));

		        Charla c2 = new Charla("IA Moderna", s2);
		        c2.addParticipante(new Participante("Carlos", "Flores", 24));

		        evento.addCharla(c1);
		        evento.addCharla(c2);

		        evento.mostrarEvento();
		    }
		}
