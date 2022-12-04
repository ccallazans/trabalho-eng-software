package Command;

import Biblioteca.Biblioteca;

public class DevolverCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        if (uArgs.length < 3) {
            System.out.println("Insucesso! Argumentos Faltando!");
            return;
        }
        Biblioteca.getInstance().devolver(uArgs[1], uArgs[2]);
    }
}
