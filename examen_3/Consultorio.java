package examen_3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Consultorio {

    private String consultas = "consultas.json";
    private String medicos = "medicos.json";

    public Consultorio() {

    }

    private List<Medico> leerMedicos() {
        try (Reader reader = new FileReader(medicos)) {
            Type listType = new TypeToken<ArrayList<Medico>>(){}.getType();
            List<Medico> lista = new Gson().fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarMedicos(List<Medico> lista) {
        try (Writer writer = new FileWriter(medicos)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Consulta> leerConsultas() {
        try (Reader reader = new FileReader(consultas)) {
            Type listType = new TypeToken<ArrayList<Consulta>>(){}.getType();
            List<Consulta> lista = new Gson().fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarConsultas(List<Consulta> lista) {
        try (Writer writer = new FileWriter(consultas)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void incisoA_AltaDatos() {
        List<Medico> listaMedicos = new ArrayList<>();
        List<Consulta> listaConsultas = new ArrayList<>();

        Medico m1 = new Medico(101, "Alex", "Condori", 5);
        Medico m2 = new Medico(102, "Maria", "Perez", 10);
        Medico m3 = new Medico(103, "Juan", "Lopez", 2);
        
        listaMedicos.add(m1);
        listaMedicos.add(m2);
        listaMedicos.add(m3);

        listaConsultas.add(new Consulta(555, "Ana", "Rios", 101, 25, "Diciembre", 2025));
        listaConsultas.add(new Consulta(666, "Beto", "Vela", 101, 10, "Octubre", 2025));
        listaConsultas.add(new Consulta(777, "Carla", "Mora", 101, 1, "Enero", 2026));

        listaConsultas.add(new Consulta(888, "Dario", "Sanz", 102, 15, "Noviembre", 2025));
        listaConsultas.add(new Consulta(999, "Elena", "Cruz", 102, 16, "Noviembre", 2025));
        listaConsultas.add(new Consulta(111, "Fabio", "Diaz", 102, 17, "Noviembre", 2025));

        listaConsultas.add(new Consulta(222, "Gina", "Luz", 103, 25, "Diciembre", 2025));
        listaConsultas.add(new Consulta(333, "Hugo", "Paz", 103, 5, "Agosto", 2025));
        listaConsultas.add(new Consulta(444, "Ines", "Rey", 103, 1, "Enero", 2026));

        guardarMedicos(listaMedicos);
        guardarConsultas(listaConsultas);
        System.out.println("Inciso A: Se dieron de alta 3 médicos y 9 consultas.");
    }

    public void incisoB_BajaMedico(String nombreX, String apellidoY) {
        List<Medico> listaMedicos = leerMedicos();
        List<Consulta> listaConsultas = leerConsultas();

        int idMedicoEliminar = -1;
        boolean encontrado = false;

        for (int i = 0; i < listaMedicos.size(); i++) {
            Medico m = listaMedicos.get(i);
            if (m.getNombreMed().equalsIgnoreCase(nombreX) && m.getApellidoMed().equalsIgnoreCase(apellidoY)) {
                idMedicoEliminar = m.getIdMed();
                listaMedicos.remove(i);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {

            int finalId = idMedicoEliminar;
            listaConsultas.removeIf(c -> c.getIdMed() == finalId);

            guardarMedicos(listaMedicos);
            guardarConsultas(listaConsultas);
            System.out.println("Inciso B: Se eliminó al médico " + nombreX + " " + apellidoY + " y sus consultas.");
        } else {
            System.out.println("Inciso B: No se encontró al médico " + nombreX + " " + apellidoY);
        }
    }

    public void incisoC_CambiarFechasFestivas() {
        List<Consulta> listaConsultas = leerConsultas();
        boolean huboCambios = false;

        for (Consulta c : listaConsultas) {
            boolean esNavidad = (c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre"));
            boolean esAnioNuevo = (c.getDia() == 1 && c.getMes().equalsIgnoreCase("Enero"));

            if (esNavidad || esAnioNuevo) {
                c.setDia(30);
                huboCambios = true;
            }
        }

        if (huboCambios) {
            guardarConsultas(listaConsultas);
            System.out.println("Inciso C: Se reprogramaron las consultas de Navidad y Año Nuevo al día 30.");
        } else {
            System.out.println("Inciso C: No se encontraron consultas en fechas festivas.");
        }
    }
}