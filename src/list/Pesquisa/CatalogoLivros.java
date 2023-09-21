package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, Integer anoDePublicacao){
        livroList.add(new Livro(titulo,autor,anoDePublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> autorEspecificoLivroList = new ArrayList<>();
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if (l.getAutor().equalsIgnoreCase(autor)){
                    autorEspecificoLivroList.add(l);
                }
            }
            return autorEspecificoLivroList;
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Livro> pesquisarPorIntervaloAnos(Integer anoIncial, Integer anoFinal){
        List<Livro> periodoLivroList = new ArrayList<>();
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if (l.getAnoDePublicacao() >= anoIncial && l.getAnoDePublicacao() <= anoFinal){
                    periodoLivroList.add(l);
                }
            }
            return periodoLivroList;
        }else{
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro tituloEspecificoLivro = null;
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if (l.getTitulo().equalsIgnoreCase(titulo)){
                    tituloEspecificoLivro = l;
                    break;
                }
            }
            return tituloEspecificoLivro;
        }else{
            throw new RuntimeException("A lista está vazia!");
        }

    }


}
