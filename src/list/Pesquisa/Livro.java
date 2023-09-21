package list.Pesquisa;

public class Livro {

    private String titulo;
    private String autor;
    private Integer anoDePublicacao;

    public Livro(String titulo, String autor, Integer anoDePublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnoDePublicacao() {
        return anoDePublicacao;
    }

}
