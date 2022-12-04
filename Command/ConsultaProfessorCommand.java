package Command;

import Biblioteca.Biblioteca;

public class ConsultaProfessorCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        if (uArgs.length < 2) {
            System.out.println("Insucesso! Argumentos Faltando!");
            return;
        }
        Biblioteca.getInstance().consultaProfessor(uArgs[1]);
    }
}
