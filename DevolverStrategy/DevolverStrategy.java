package DevolverStrategy;

import Livro.Livro;
import Usuario.Usuario;

public interface DevolverStrategy {
    public void devolver(Usuario usuario, Livro emprestimoLivro);
}
