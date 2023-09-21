package generics;

import java.util.HashMap;
import java.util.Map;

public class GenericsExampleMap {
    public static void main(String[] args) {
        Map mapaSemGenerics = new HashMap();
        mapaSemGenerics.put("Chave 1", 10);
        mapaSemGenerics.put("Chave 2", "valor");

        Map<Integer,String> mapaComGenerics = new HashMap<>();
        mapaComGenerics.put(0, "Elemento 1");
        mapaComGenerics.put(1, "Elemento 2");

        for (Map.Entry<Integer, String> entry : mapaComGenerics.entrySet()) {
            Integer chave = entry.getKey();
            String valor = entry.getValue();
            System.out.println("Chave: " + chave + ", Valor: " + valor);
        }

        for (Object obj : mapaSemGenerics.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            String chave = (String) entry.getKey();
            Object valor = entry.getValue();
            System.out.println("Chave: " + chave + ", Valor: " + valor);
        }
    }
}
