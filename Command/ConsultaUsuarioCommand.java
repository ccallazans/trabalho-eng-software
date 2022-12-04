package Command;

import Biblioteca.Biblioteca;

public class ConsultaUsuarioCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        if (uArgs.length < 2) {
            System.out.println("Insucesso! Argumentos Faltando!");
            return;
        }
        Biblioteca.getInstance().consultarUsuario(uArgs[1]);
    }
}
