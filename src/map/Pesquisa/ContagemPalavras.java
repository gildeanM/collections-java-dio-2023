package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    Map<String,Integer> numPalavrasMap;

    public ContagemPalavras() {
        this.numPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        numPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!numPalavrasMap.isEmpty()){
            numPalavrasMap.remove(palavra);
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirContagemPalavras(){
        if(!numPalavrasMap.isEmpty()){
            System.out.println(numPalavrasMap);
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public String encontrarPalavraMaisFrequente(){
        int maiorContagem = Integer.MIN_VALUE;
        String palavraMaiorContagem = null;
        if(!numPalavrasMap.isEmpty()){
            for (String palavra : numPalavrasMap.keySet()) {
                if(maiorContagem <= numPalavrasMap.get(palavra)){
                    maiorContagem = numPalavrasMap.get(palavra);
                    palavraMaiorContagem = palavra;
                }
            }
            return palavraMaiorContagem;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);

        System.out.println();contagemLinguagens.encontrarPalavraMaisFrequente());


    }


}
