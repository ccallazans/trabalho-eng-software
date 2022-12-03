package Command;

import Biblioteca.Biblioteca;

public class ConsultaLivroCommand implements Command {

    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        Biblioteca.getInstance().consultarLivro(uArgs[1]);
    }
}
