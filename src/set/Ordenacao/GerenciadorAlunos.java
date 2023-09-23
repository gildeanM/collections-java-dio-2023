package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula,double media){
        alunosSet.add(new Aluno(nome,matricula,media));
    }

    public void removerAluno(Long matricula){
        Set<Aluno> alunosRemover = new HashSet<>();
        if(!alunosSet.isEmpty()){
            for (Aluno a : alunosSet) {
                if(a.getMatricula() == matricula){
                    alunosRemover.add(a);
                }
            }
            alunosSet.removeAll(alunosRemover);
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNomeSet = new TreeSet<>(alunosSet);

        if(!alunosSet.isEmpty()){
            return alunosPorNomeSet;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }


    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNotaSet = new TreeSet<>(new ComparatorPorNota());

        if(!alunosSet.isEmpty()){
            alunosPorNotaSet.addAll(alunosSet);
            return alunosPorNotaSet;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    public void exibirAlunos(){
        if(!alunosSet.isEmpty()){
            for (Aluno a : alunosSet) {
                System.out.println(a);
            }
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }
    }


    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        System.out.println("ALUNOS");
        gerenciadorAlunos.exibirAlunos();

        System.out.println("ALUNOS POR NOME");
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        System.out.println("ALUNOS POR NOTA");
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());



    }

}
