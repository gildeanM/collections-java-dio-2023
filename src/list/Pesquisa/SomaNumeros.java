package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numerosList;

    public SomaNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(Integer numero){
        numerosList.add(numero);
    }

    public Integer calcularSoma(){
        Integer somaTotal = 0;
        if(!numerosList.isEmpty()){
            for (Integer numero : numerosList){
                somaTotal += numero;
            }
            return somaTotal;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public Integer encontrarMaiorNumero(){
        Integer maiorNumero = 0;
        if(!numerosList.isEmpty()){
            for (Integer numero : numerosList){
                maiorNumero = Math.max(maiorNumero, numero);
            }
            return maiorNumero;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public Integer encontrarMenorNumero(){
        Integer menorNumero = 0;
        if(!numerosList.isEmpty()){
            for (Integer numero : numerosList){
                if(menorNumero == 0){
                    menorNumero = numero;
                }else {
                    menorNumero = Math.min(menorNumero, numero);
                }
            }
            return menorNumero;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public List<Integer> exibirNumeros(){
        return numerosList;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(3);

        System.out.println("NUMEROS");
        System.out.println(somaNumeros.exibirNumeros());

        System.out.println("SOMA");
        System.out.println(somaNumeros.calcularSoma());

        System.out.println("MAIOR");
        System.out.println(somaNumeros.encontrarMaiorNumero());

        System.out.println("MENOR");
        System.out.println(somaNumeros.encontrarMenorNumero());
    }


}
