package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    Map<String,Integer> contatosMap;

    public AgendaContatos() {
        this.contatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        contatosMap.put(nome,telefone);
    }

    public void removerContato(String nome){
        if(!contatosMap.isEmpty()){
            contatosMap.remove(nome);
        }else{
            throw new RuntimeException("A agenda está vazia!");
        }
    }

    public void exibirContatos(){
        if(!contatosMap.isEmpty()){
            System.out.println(contatosMap);
        }else{
            throw new RuntimeException("A agenda está vazia!");
        }
    }

    public Integer pesquisarPorNome(String nome){

        Integer numeroPorNome = null;

        if(!contatosMap.isEmpty()){
            numeroPorNome = contatosMap.get(nome);
            if(numeroPorNome == null){
                System.out.println("Contato não encontrado na agenda");
            }
            System.out.println(contatosMap);
        }else{
            throw new RuntimeException("A agenda está vazia!");
        }
        return numeroPorNome;
    }


    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        // Adicionar contatos
        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("João", 5665);
        agendaContatos.adicionarContato("Carlos", 1111111);
        agendaContatos.adicionarContato("Ana", 654987);
        agendaContatos.adicionarContato("Maria", 1111111);
        agendaContatos.adicionarContato("Camila", 44444);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Ana");
        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Maria"));


    }


}
