package ReservarStrategy;

import Livro.Livro;
import Usuario.Usuario;

public interface ReservarStrategy {

    public void reservar(Usuario usuario, Livro reservaLivro, String data);

}
