package EmprestimoStrategy;

import Livro.Livro;
import Usuario.Usuario;

public interface EmprestimoStrategy {

    public void emprestar(Usuario usuario, Livro emprestimoLivro);

}
