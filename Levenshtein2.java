package levenshteinprueba;

import java.util.ArrayList;

public class Levenshtein2 {

    // Clase auxiliar para guardar resultados
    private static class Resultado {
        String s1;
        String s2;
        int distancia;

        Resultado(String s1, String s2, int distancia) {
            this.s1 = s1;
            this.s2 = s2;
            this.distancia = distancia;
        }
    }

    private ArrayList<Resultado> listaResultados;

    public Levenshtein2() {
        listaResultados = new ArrayList<>();
    }

    public int distanciaDeCadenas(String s1, String s2) {
        // Limpiar la lista cada vez que se llama desde el exterior
        listaResultados.clear();
        return distanciaRec(s1, s2);
    }

    private int distanciaRec(String s1, String s2) {
        // Revisar si ya existe el resultado
        for (Resultado r : listaResultados) {
            if (r.s1.equals(s1) && r.s2.equals(s2)) {
                return r.distancia;
            }
        }

        int resultado;

        if (s1.length() == 0 || s2.length() == 0) {
            resultado = s1.length() + s2.length();
        } else if (s1.charAt(0) == s2.charAt(0)) {
            resultado = distanciaRec(s1.substring(1), s2.substring(1));
        } else {
            int res1 = distanciaRec(s1.substring(1), s2) + 1;        // eliminación
            int res2 = distanciaRec(s1, s2.substring(1)) + 1;        // inserción
            int res3 = distanciaRec(s1.substring(1), s2.substring(1)) + 1; // sustitución
            resultado = Math.min(res1, Math.min(res2, res3));
        }

        // Guardar el resultado en la lista
        listaResultados.add(new Resultado(s1, s2, resultado));

        return resultado;
    }
}