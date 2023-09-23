package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Set<Tarefa> tarefasRemoverSet = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefasRemoverSet.add(t);
                }
            }
            tarefaSet.removeAll(tarefasRemoverSet);
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public void exibirTarefas(){

        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                System.out.println(t);
            }
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }


    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidasSet = new HashSet<>();

        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if(t.isConcluida()){
                    tarefasConcluidasSet.add(t);
                }
            }
            return tarefasConcluidasSet;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }

    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentesSet = new HashSet<>();

        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if(!t.isConcluida()){
                    tarefasPendentesSet.add(t);
                }
            }
            return tarefasPendentesSet;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }

    }

    public Tarefa marcarTarefaConcluida(String descricao){
        Tarefa tarefaAtualizada = null;
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if(!t.isConcluida() && t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(Boolean.TRUE);
                    tarefaAtualizada = t;
                    break;
                }
            }
            return tarefaAtualizada;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public Tarefa marcarTarefaPendente(String descricao){
        Tarefa tarefaAtualizada = null;
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet) {
                if(t.isConcluida() && t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(Boolean.FALSE);
                    tarefaAtualizada = t;
                    break;
                }
            }
            return tarefaAtualizada;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public void limparListaTarefas(){
        tarefaSet.removeAll(tarefaSet);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

//        listaTarefas.exibirTarefas();
//        System.out.println(listaTarefas.contarTarefas());
//
//        listaTarefas.removerTarefa("Organizar a mesa de trabalho");
//        listaTarefas.exibirTarefas();
//
//        listaTarefas.marcarTarefaConcluida("Estudar Java");
//        listaTarefas.marcarTarefaConcluida("Ler Livro");
//        listaTarefas.marcarTarefaConcluida("Fazer exercícios físicos");
//
//        System.out.println(listaTarefas.obterTarefasConcluidas());
//        listaTarefas.marcarTarefaPendente("Ler livro");
//
//        listaTarefas.exibirTarefas();
//        System.out.println(listaTarefas.obterTarefasPendentes());


        listaTarefas.limparListaTarefas();
        System.out.println(listaTarefas.obterTarefasPendentes());

    }

}
