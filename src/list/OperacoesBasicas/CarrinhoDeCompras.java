package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {this.itemList = new ArrayList<>();}

    public void adicionarItem(String nome, Double preco, Integer quantidade){
        itemList.add(new Item(nome,preco,quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        if(!itemList.isEmpty()){
            for(Item i : itemList){
                if(i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        }else{
            System.out.println("O carrinho está vazio!");
        }
    }

    public void calcularValorTotal() {
        Double valorTotal = 0.00;
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                valorTotal += i.getPreço()*i.getQuantidade();
            }
            System.out.println("O valor da compra é de R$ "+valorTotal);
        } else {
            System.out.println("O carrinho está vazio!");
        }

    }

    public void exibirItens(){
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                System.out.println("Nome: " + i.getNome() + ", Preço: " + i.getPreço() + ", Quantidade: " + i.getQuantidade());
            }
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Arroz",5.90,5);
        carrinhoDeCompras.adicionarItem("Feijão", 4.00, 5);
        carrinhoDeCompras.adicionarItem("Café", 5.00, 2);

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();

        carrinhoDeCompras.removerItem("Café");

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();
    }

}
