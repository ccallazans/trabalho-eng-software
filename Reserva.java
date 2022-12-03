public class Reserva {
    private String data;
    private Livro livro;
    private Usuario usuario;

    public Reserva(String data, Livro livro, Usuario usuario) {
        this.data = data;
        this.livro = livro;
        this.usuario = usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
