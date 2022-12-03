package Livro;

import java.util.ArrayList;

public class Exemplar {
    public Livro livro;
    public String codigoExemplar;

    public Exemplar(Livro livro, String codigoExemplar) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }
}
