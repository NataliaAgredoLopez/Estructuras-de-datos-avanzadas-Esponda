package levenshteinprueba;

public class Levenshtein {

    public int distanciaDeCadenas(String s1, String s2, int cont, int asintota) {
        if (s1.length() == 0 || s2.length() == 0) {
            return s1.length() + s2.length() + cont; // caso de cadena vacía
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return distanciaDeCadenas(s1.substring(1), s2.substring(1), cont, asintota);
        } else {
            int res2 = distanciaDeCadenas(s1.substring(1), s2, cont + 1, asintota);
            int res3 = distanciaDeCadenas(s1, s2.substring(1), cont + 1, asintota);
            int res4 = distanciaDeCadenas(s1.substring(1), s2.substring(1), cont + 1, asintota);
            return min(res2, res3, res4);
        }
    }

    private int min(int i1, int i2, int i3) {
        if (i1 <= i2 && i1 <= i3) return i1;
        if (i2 <= i3) return i2;
        return i3;
    }
}
