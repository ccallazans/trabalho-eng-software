package Command;

import Biblioteca.Biblioteca;

public class DevolverCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        Biblioteca.getInstance().devolver(uArgs[1], uArgs[2]);
    }
}
