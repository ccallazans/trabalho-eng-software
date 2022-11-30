import Biblioteca.Biblioteca;
import Livro.Livro;
import Usuario.AlunoGraduacao;
import Usuario.AlunoPosGraduacao;
import Usuario.Professor;
import Livro.Exemplar;
import Usuario.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro(100, "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6ª", 2000);
        Livro livro2 = new Livro(101, "UML – Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000);
        Livro livro3 = new Livro(200, "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", 2014);
        Livro livro4 = new Livro(201, "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1ª", 2002);
        Livro livro5 = new Livro(300, "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999);
        Livro livro6 = new Livro(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3ª", 2014);
        Livro livro7 = new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", 1994);
        Livro livro8 = new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", "3ª", 2003);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarExemplar(new Exemplar(livro1, "01"));
        biblioteca.adicionarExemplar(new Exemplar(livro1, "02"));
        biblioteca.adicionarExemplar(new Exemplar(livro2, "03"));
        biblioteca.adicionarExemplar(new Exemplar(livro3, "04"));
        biblioteca.adicionarExemplar(new Exemplar(livro4, "05"));
        biblioteca.adicionarExemplar(new Exemplar(livro5, "06"));
        biblioteca.adicionarExemplar(new Exemplar(livro5, "07"));
        biblioteca.adicionarExemplar(new Exemplar(livro7, "08"));
        biblioteca.adicionarExemplar(new Exemplar(livro7, "09"));

        biblioteca.adicionarUsuario(new AlunoGraduacao(123, "João da Silva"));
        biblioteca.adicionarUsuario(new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues"));
        biblioteca.adicionarUsuario(new AlunoGraduacao(789, "Pedro Paulo"));
        biblioteca.adicionarUsuario(new Professor(100, "Carlos Lucena"));

        String entrada;
        do {
            System.out.println("### Digite o comando desejado:");
            System.out.println("# Empréstimo: emp <codigo_do_usuario> <codigo_do_livro>");
            System.out.println("# Devolução: dev <codigo_do_usuario> <codigo_do_livro>");
            System.out.println("# FazerReserva: res <codigo_do_usuario> <codigo_do_livro>");
            System.out.println("# Observar: obs <codigo_do_usuario> <codigo_do_livro>");
            System.out.println("# Sair: sair");

            Scanner leitor = new Scanner(System.in);
            entrada = leitor.next();

        } while (!entrada.equals("sair"));
    }
}