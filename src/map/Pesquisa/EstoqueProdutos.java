package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long,Produto> produtoMap;

    public EstoqueProdutos() {
        this.produtoMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco){
        produtoMap.put(codigo,new Produto(nome,quantidade,preco));
    }

    public void exibirProdutos(){
        if(!produtoMap.isEmpty()){
            System.out.println(produtoMap);
        }else{
            throw new RuntimeException("O estoque está vazio!");
        }
    }

    public Double calcularValorTotalEstoque(){
        double valorTotal = 0;
        if(!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()) {
                valorTotal += p.getQuantidade() * p.getPreco();
            }
            return valorTotal;
        }else{
            throw new RuntimeException("O estoque está vazio!");
        }
    }

    public Produto obterProdutoMaisCaro(){
        double maiorPreco = Double.MIN_VALUE;
        Produto produtoMaisCaro = null;
        if(!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()) {
                if(maiorPreco <= p.getPreco()){
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
            return produtoMaisCaro;
        }else{
            throw new RuntimeException("O estoque está vazio!");
        }
    }

    public Produto obterProdutoMaisBarato(){
        double menorPreco = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;
        if(!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()) {
                if(menorPreco >= p.getPreco()){
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
            return produtoMaisBarato;
        }else{
            throw new RuntimeException("O estoque está vazio!");
        }
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        double valorMaior = Double.MIN_VALUE;
        Produto produtoMaiorValor = null;
        if(!produtoMap.isEmpty()){
            for (Produto p : produtoMap.values()) {
                if(valorMaior <= (p.getQuantidade() * p.getPreco())){
                    valorMaior = p.getQuantidade() * p.getPreco();
                    produtoMaiorValor = p;
                }

            }
            return produtoMaiorValor;
        }else{
            throw new RuntimeException("O estoque está vazio!");
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        // Adiciona produtos ao estoque
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

        estoque.exibirProdutos();

        System.out.println(estoque.calcularValorTotalEstoque());
        System.out.println(estoque.obterProdutoMaisCaro());
        System.out.println(estoque.obterProdutoMaisBarato());

        System.out.println(estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    }

}
