package Command;

import Biblioteca.Biblioteca;

public class ReservarCommand implements Command {
    @Override
    public void execute(String[] uArgs) {
        // TODO Auto-generated method stub
        Biblioteca.getInstance().reservar(uArgs[1], uArgs[2]);
    }
}
