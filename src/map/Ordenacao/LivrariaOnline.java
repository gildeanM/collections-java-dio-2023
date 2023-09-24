package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {

    Map<String,Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livroMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        if(!livroMap.isEmpty()){
            for (Map.Entry<String,Livro> entry : livroMap.entrySet()) {
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    livroMap.remove(entry.getKey());
                }
            }
        }else{
            throw new RuntimeException("A livraria está vazia");
        }
    }

    public Map<String,Livro> exibirLivrosOrdenadosPorPreco(){
        if(!livroMap.isEmpty()){
            List<Map.Entry<String,Livro>> livrosPorPreco = new ArrayList<>(livroMap.entrySet());
            Collections.sort(livrosPorPreco, new ComparatorPorPreco());

            Map<String,Livro> livrosOrdenadosPorpreco = new LinkedHashMap<>();

            for (Map.Entry<String,Livro> entry : livrosPorPreco) {
                livrosOrdenadosPorpreco.put(entry.getKey(), entry.getValue());
            }
            return livrosOrdenadosPorpreco;
        }else{
            throw new RuntimeException("A livraria está vazia");
        }
    }

    public Map<String,Livro> exibirLivrosOrdenadosPorAutor(){

        if(!livroMap.isEmpty()){
            List<Map.Entry<String,Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livroMap.entrySet());
            Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

            Map<String,Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

            for (Map.Entry<String,Livro> entry : livrosParaOrdenarPorAutor) {
                livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
            }
            return livrosOrdenadosPorAutor;
        }else{
            throw new RuntimeException("A livraria está vazia");
        }
    }

    public Map<String,Livro> pesquisaLivroPorAutor(String autor){
        Map<String,Livro> livrosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String,Livro> entry : livroMap.entrySet()) {
            Livro livro = entry.getValue();
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.put(entry.getKey(),livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;

        if (!livroMap.isEmpty()) {
            for (Livro livro : livroMap.values()) {
                if (livro.getPreco() > precoMaisAlto) {
                    precoMaisAlto = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livroMap.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisAlto) {
                Livro livroComPrecoMaisAlto = livroMap.get(entry.getKey());
                livrosMaisCaros.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisCaros;
    }

    public List<Livro> obterLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;

        if (!livroMap.isEmpty()) {
            for (Livro livro : livroMap.values()) {
                if (livro.getPreco() < precoMaisBaixo) {
                    precoMaisBaixo = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livroMap.entrySet()) {
            if(entry.getValue().getPreco() == precoMaisBaixo) {
                Livro livroComPrecoMaisBaixo = livroMap.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisBaixo);
            }
        }
        return livrosMaisBaratos;
    }



}
