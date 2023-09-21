package list.OperacoesBasicas;

public class Item {

    private String nome;
    private Double preço;
    private Integer quantidade;

    public Item(String nome, Double preço, Integer quantidade) {
        this.nome = nome;
        this.preço = preço;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreço() {
        return preço;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
