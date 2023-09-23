package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvidado){
        convidadoSet.add(new Convidado(nome,codigoConvidado));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Set<Convidado> removerConvidadoSet = new HashSet<>();
        if (!convidadoSet.isEmpty()){
            for (Convidado c : convidadoSet) {
                if (c.getCodigoConvite() == codigoConvite){
                    removerConvidadoSet.add(c);
                }
            }
            convidadoSet.removeAll(removerConvidadoSet);
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        if (!convidadoSet.isEmpty()){
            for (Convidado c : convidadoSet) {
                System.out.println(c);
            }
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        // Adicionando convidados ao conjunto
        conjuntoConvidados.adicionarConvidado("Alice", 1234);
        conjuntoConvidados.adicionarConvidado("Bob", 1235);
        conjuntoConvidados.adicionarConvidado("Charlie", 1235);
        conjuntoConvidados.adicionarConvidado("David", 1236);

        conjuntoConvidados.exibirConvidados();
        System.out.println(conjuntoConvidados.contarConvidados());

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1235);

        conjuntoConvidados.exibirConvidados();
        System.out.println(conjuntoConvidados.contarConvidados());

    }
}
