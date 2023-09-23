package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {

    private List<Integer> numerosList;

    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numerosList.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosAscendentes = new ArrayList<>(numerosList);
        if(!numerosList.isEmpty()){
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> numerosDescendentes = new ArrayList<>(numerosList);
        if(!numerosList.isEmpty()){
           numerosDescendentes.sort(Collections.reverseOrder());
            return numerosDescendentes;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirNumeros(){
        if(!numerosList.isEmpty()){
            System.out.println(this.numerosList);
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.adicionarNumero(3);
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(1);
        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(9);
        ordenacaoNumeros.adicionarNumero(5);

        System.out.println("ORDEM NATURAL");
        ordenacaoNumeros.exibirNumeros();
        System.out.println("ORDEM ASCENDENTE");
        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println("ORDEM DESCENDENTE");
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }

}
