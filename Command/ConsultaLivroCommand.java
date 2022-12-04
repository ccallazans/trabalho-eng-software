package Command;

import Biblioteca.Biblioteca;

public class ConsultaLivroCommand implements Command {

    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        if (uArgs.length < 2) {
            System.out.println("Insucesso! Argumentos Faltando!");
            return;
        }
        Biblioteca.getInstance().consultarLivro(uArgs[1]);
    }
}
