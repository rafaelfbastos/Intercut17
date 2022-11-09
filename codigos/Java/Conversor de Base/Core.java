import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Core {

    private static ArrayList<String> listaCaracteres = new ArrayList<>(
            Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"));

    private static ArrayList<String> listaBases = new ArrayList<>(
            Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "16", "hex", "hexdecimal"));

    private static Map<String, Integer> mapCaracteres = Map.ofEntries(
            Map.entry("0", 0),
            Map.entry("1", 1),
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("a", 10),
            Map.entry("b", 11),
            Map.entry("c", 12),
            Map.entry("d", 13),
            Map.entry("e", 14),
            Map.entry("f", 15));

    private static Map<Integer, String> mapNumeros = Map.ofEntries(
            Map.entry(10, "a"),
            Map.entry(11, "b"),
            Map.entry(12, "c"),
            Map.entry(13, "d"),
            Map.entry(14, "e"),
            Map.entry(15, "f"));

    public static boolean validarNumeroBase(String numero, String baseAtual) {

        int base = baseParaInt(baseAtual);

        ArrayList<String> caracteresValidos = new ArrayList<>(listaCaracteres.subList(0, base));

        return numero.chars().allMatch(c -> caracteresValidos.contains(Character.toString(c)));
    }

    public static long converterParaBase10(String numeros, String baseAtual) {

        int base = baseParaInt(baseAtual);

        ArrayList<Integer> algarismos = new ArrayList<>();

        numeros.chars().forEach(c -> algarismos.add(mapCaracteres.get(Character.toString(c))));

        Collections.reverse(algarismos);

        long resultado = 0l;

        for (int i = 0; i < algarismos.size(); i++) {
            resultado = resultado + (int) Math.pow(base, i) * algarismos.get(i);
        }
        return resultado;
    }

    public static String converterBase(String numero, String baseAtual, String baseDesejada) {

        int base = baseParaInt(baseDesejada);
        long numeroDecimal = converterParaBase10(numero, baseAtual);

        ArrayList<Integer> algarismos = new ArrayList<>();

        while (numeroDecimal >= base) {

            algarismos.add((int) numeroDecimal % base);
            numeroDecimal = numeroDecimal / base;
        }
        algarismos.add((int) numeroDecimal);
        Collections.reverse(algarismos);

        StringBuffer resultado = new StringBuffer();

        for (Integer algarismo : algarismos) {
            if (algarismo < 10) {
                resultado.append(algarismo);
            } else {
                resultado.append(mapNumeros.get(algarismo));
            }
        }

        return resultado.toString();
    }

    public static boolean validarBases(String base) {
        return listaBases.contains(base);
    }

    private static int baseParaInt(String baseAtual) {
        int base;

        if (baseAtual.equals("hex") || baseAtual.equals("hexadecimal")) {
            base = 16;
        } else {
            base = Integer.parseInt(baseAtual);
        }

        return base;
    }

}
