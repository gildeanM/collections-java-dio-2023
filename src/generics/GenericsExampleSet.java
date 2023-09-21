package generics;

import java.util.HashSet;
import java.util.Set;

public class GenericsExampleSet {
    public static void main(String[] args) {

        Set conjuntoSemGenerics = new HashSet();
        conjuntoSemGenerics.add("Elemento 1");
        conjuntoSemGenerics.add(10);

        Set<String> conjuntoComGenerics = new HashSet<>();
        conjuntoComGenerics.add("Elemento 1");
        conjuntoComGenerics.add("Elemento 2");

        //Iterando sobre a lista com Generics
        for (String elemento : conjuntoComGenerics){
            System.out.println(elemento);
        }

        //Iterando sobre a lista sem Generics(necessário fazer cast)
        for(Object elemento : conjuntoSemGenerics){
            String str = elemento.toString();
            System.out.println(str);
        }
    }

}
