package Command;

import java.util.HashMap;

public class Invoker {
    private HashMap cmds = new HashMap();

    public Invoker() {
        initCommands();
    }

    private void initCommands() {
        cmds.put("dev", new DevolverCommand());
        cmds.put("emp", new EmprestarCommand());
        cmds.put("res", new ReservarCommand());
        cmds.put("obs", new ObservadorCommand());
        cmds.put("liv", new ConsultaLivroCommand());
        cmds.put("usu", new ConsultaUsuarioCommand());
        cmds.put("ntf", new ConsultaProfessorCommand());
        cmds.put("sai", new SairCommand());
    }

    public void service(String[] userArgs) {
        Command c = (Command) cmds.get(userArgs[0]);
        if (c == null) {
            System.out.println("Insucesso! Comando Inválido!");
            return;
        }
        c.execute(userArgs);
    }

}
