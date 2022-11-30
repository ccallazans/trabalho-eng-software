package Livro;

import Notificacao.Consulta;

public class Livro {
    public int codigoIdentificacao;
    public String titulo;
    String editora;
    String autores;
    String edicao;
    int anoDaPublicação;

    Consulta consulta = new Consulta(this);

    public Livro(int codigoIdentificacao, String titulo, String editora, String autores, String edicao, int anoDaPublicação) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDaPublicação = anoDaPublicação;
    }

    public int getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public String getTitulo() {
        return titulo;
    }
}
