package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String,String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String nome, String definicao){
        dicionarioMap.put(nome,definicao);
    }

    public void removerPalavra(String nome){
        if(!dicionarioMap.isEmpty()){
            dicionarioMap.remove(nome);
        }else{
            throw new RuntimeException("O dicionario está vazio");
        }
    }

    public void exibirPalavras(){
        if(!dicionarioMap.isEmpty()){
            System.out.println(dicionarioMap);
        }else{
            throw new RuntimeException("O dicionario está vazio");
        }
    }

    public String pesquisarPorPalavra(String palavra){
        String pesquisaPorPalavra = null;

        if(!dicionarioMap.isEmpty()){
            pesquisaPorPalavra = dicionarioMap.get(palavra);
            if(pesquisaPorPalavra == null){
                System.out.println("O dicinario não possui essa palavra");
            }
        }else{
            throw new RuntimeException("O dicionario está vazio");
        }
        return pesquisaPorPalavra;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        // Adicionar palavras (linguagens de programação)
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("typescript");
        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("kotlin"));

    }

}
