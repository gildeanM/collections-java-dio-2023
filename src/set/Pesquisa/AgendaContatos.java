package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome,numero));
    }

    public void exibirContatos(){
        if(!contatoSet.isEmpty()){
            for (Contato c : contatoSet) {
                System.out.println(c);
            }
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNomeSet = new HashSet<>();
        if(!contatoSet.isEmpty()){
            for (Contato c : contatoSet) {
                if (c.getNome().startsWith(nome)) {
                    contatosPorNomeSet.add(c);
                }
//                if(c.getNome().contains(nome)){
//                    contatosPorNomeSet.add(c);
//                }
            }
            return contatosPorNomeSet;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        if(!contatoSet.isEmpty()){
            for (Contato c : contatoSet) {
                if(c.getNome().equalsIgnoreCase(nome)){
                    c.setNumeroTelefone(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        }else{
            throw new RuntimeException("A lista está vazia");
        }

    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();



        // Adicionando contatos à agenda
        agendaContatos.adicionarContato("João", 123456789);
        agendaContatos.adicionarContato("Maria", 987654321);
        agendaContatos.adicionarContato("Maria Fernandes", 55555555);
        agendaContatos.adicionarContato("Ana", 88889999);
        agendaContatos.adicionarContato("Fernando", 77778888);
        agendaContatos.adicionarContato("Pedro Fernando", 55555555);


//        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Fernando"));

        agendaContatos.atualizarNumeroContato("Pedro Fernando", 40028922);

        System.out.println(agendaContatos.pesquisarPorNome("Pedro"));
    }

}
