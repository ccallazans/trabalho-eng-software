package Command;

import Biblioteca.Biblioteca;

public class ObservadorCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        if (uArgs.length < 3) {
            System.out.println("Insucesso! Argumentos Faltando!");
            return;
        }
        Biblioteca.getInstance().observar(uArgs[1], uArgs[2]);
    }
}
