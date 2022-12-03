
import java.util.HashMap;

import Command.Command;
import Command.ConsultaLivroCommand;
import Command.ConsultaProfessorCommand;
import Command.ConsultaUsuarioCommand;
import Command.DevolverCommand;
import Command.ObservadorCommand;
import Command.SairCommand;

public class Invoker {
    private HashMap cmds = new HashMap();

    public Invoker() {
        initCommands();
    }

    private void initCommands() {
        cmds.put("dev", new DevolverCommand());
        cmds.put("res", new ReservarCommand());
        cmds.put("obs", new ObservadorCommand());
        cmds.put("liv", new ConsultaLivroCommand());
        cmds.put("usu", new ConsultaUsuarioCommand());
        cmds.put("ntf", new ConsultaProfessorCommand());
        cmds.put("sair", new SairCommand());
    }

    public void service(String[] userArgs) {
        Command c = (Command) cmds.get(userArgs[0]);
        c.execute(userArgs);
    }

}
