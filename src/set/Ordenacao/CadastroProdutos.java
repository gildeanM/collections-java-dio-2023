package set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto( long cod,String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome(){
       Set<Produto> produtoPorNome = new TreeSet<>(produtoSet);
       if(!produtoSet.isEmpty()){
           return produtoPorNome;
       }else{
           throw new RuntimeException("O conjunto está vazio!");
       }
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if(!produtoSet.isEmpty()){
            produtoPorPreco.addAll(produtoSet);
            return produtoPorPreco;
        }else{
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        System.out.println("PRODUTOS POR NOME");
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println("PRODUTOS POR PRECO");
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());



    }


}
