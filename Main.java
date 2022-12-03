import java.util.Scanner;

import Command.Invoker;

public class Main {
    public static void main(String[] args) {

        Invoker myInvoker = new Invoker();

        while (true) {
            Scanner sc = new Scanner(System.in);
            String entrada = sc.nextLine();

            String[] userArgs = entrada.split(" ");
            myInvoker.service(userArgs);
        }
    }
}
