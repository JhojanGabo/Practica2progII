package persis1;
public class app {
    public static void main(String[] args) {
        CharangoManager arch = new CharangoManager();
        arch.adicionar(new Charango("Madera", 10, new boolean[]{true, true, false, true, false, false, false, false, false, false})); 
        arch.adicionar(new Charango("Armadillo", 10, new boolean[]{true, true, true, true, true, true, true, true, true, true}));
        arch.guardar();
        
        arch.leer();
        arch.eliminarDañados();
        arch.ordenarPorMaterial();
        arch.listarPorMaterial("Armadillo");
    }
}



