package levenshteinprueba;

import java.util.Random;

public class LevenshteinPrueba {
    
    public static String generarCadenaAlAzar(int n, Random rnd) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        int indice;//me va a servir para elegir letra al azar
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            indice = rnd.nextInt(letras.length());
            sb.append(letras.charAt(indice));
        }
        return sb.toString();
    }

    public static String invertirCadena(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    
    public static void main(String[] args) {
        Levenshtein prueba = new Levenshtein();
        Random rnd = new Random();

        int[] longitudes = {3, 5, 7, 10};

        System.out.println("=== CADENAS ALEATORIAS ===");
        for (int n : longitudes) {
            String s1 = generarCadenaAlAzar(n, rnd);
            String s2 = generarCadenaAlAzar(n, rnd);

            long t1 = System.nanoTime();
            int distancia = prueba.distanciaDeCadenas(s1, s2, 0, 0);
            long t2 = System.nanoTime();
            double tiempo_ms = (t2 - t1) / 1e6;

            System.out.println("Cadena 1: " + s1);
            System.out.println("Cadena 2: " + s2);
            System.out.println("Distancia: " + distancia);
            System.out.println("Tiempo: " + tiempo_ms + " ms");
            System.out.println("-----------------------------");
        }

        // CADENAS INVERSAS
        System.out.println("\n=== CADENAS INVERSAS ===");
        for (int n : longitudes) {
            String s1 = generarCadenaAlAzar(n, rnd);
            String s2 = invertirCadena(s1);

            long t1 = System.nanoTime();
            int distancia = prueba.distanciaDeCadenas(s1, s2, 0, 0);
            long t2 = System.nanoTime();
            double tiempo_ms = (t2 - t1) / 1e6;

            System.out.println("Cadena 1: " + s1);
            System.out.println("Cadena 2: " + s2);
            System.out.println("Distancia: " + distancia);
            System.out.println("Tiempo: " + tiempo_ms + " ms");
            System.out.println("-----------------------------");
        }

        // CADENAS IGUALES
        System.out.println("\n=== CADENAS IGUALES ===");
        for (int n : longitudes) {
            String s1 = generarCadenaAlAzar(n, rnd);
            String s2 = s1; // idénticas

            long t1 = System.nanoTime();
            int distancia = prueba.distanciaDeCadenas(s1, s2, 0, 0);
            long t2 = System.nanoTime();
            double tiempo_ms = (t2 - t1) / 1e6;

            System.out.println("Cadena 1: " + s1);
            System.out.println("Cadena 2: " + s2);
            System.out.println("Distancia: " + distancia);
            System.out.println("Tiempo: " + tiempo_ms + " ms");
            System.out.println("-----------------------------");
        }
    }

    
    
    
}