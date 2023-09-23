package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        Set<String> removerPalavrasSet = new HashSet<>();
        if(!palavrasUnicasSet.isEmpty()){
            for (String p : palavrasUnicasSet) {
                if (p.equalsIgnoreCase(palavra)){
                    removerPalavrasSet.add(p);
                }
            }
            palavrasUnicasSet.removeAll(removerPalavrasSet);
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }


    public void verificarPalavra(String palavra){
        boolean conjuntoContemPalavra = Boolean.FALSE;
        if(!palavrasUnicasSet.isEmpty()){
            if (palavrasUnicasSet.contains(palavra)) {
                conjuntoContemPalavra = Boolean.TRUE;
            }
            System.out.println(conjuntoContemPalavra);
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirPalavrasUnicas(){
        if(!palavrasUnicasSet.isEmpty()){
            for (String p : palavrasUnicasSet) {
                System.out.println(p);
            }

        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        conjuntoLinguagens.exibirPalavrasUnicas();

        conjuntoLinguagens.verificarPalavra("C++");

        conjuntoLinguagens.removerPalavra("C++");
        conjuntoLinguagens.verificarPalavra("C++");

        conjuntoLinguagens.exibirPalavrasUnicas();


    }

}
