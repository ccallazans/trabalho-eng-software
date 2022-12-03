package Command;

import Biblioteca.Biblioteca;

public class EmprestarCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        Biblioteca.getInstance().emprestar(uArgs[1], uArgs[2]);

    }
}
