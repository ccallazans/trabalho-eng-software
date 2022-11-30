package Livro;

import java.util.ArrayList;

public class Exemplar {
    public Livro livro;
    public String codigoExemplar;
    public String status = "Disponível";

    public Exemplar(Livro livro, String codigoExemplar) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
    }

    public int getCodigoLivro() {
        return this.livro.codigoIdentificacao;
    }

    public boolean isDisponivel() {
        if (this.status.equals("Disponível")) {
            return true;
        }
        return false;
    }

}
