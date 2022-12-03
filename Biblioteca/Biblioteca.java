package Biblioteca;

import java.util.ArrayList;

import Livro.Exemplar;
import Livro.Livro;
import Usuario.AlunoGraduacao;
import Usuario.AlunoPosGraduacao;
import Usuario.Professor;
import Usuario.Usuario;

public class Biblioteca {
    private static Biblioteca instance;

    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    static ArrayList<Livro> livros = new ArrayList<Livro>();

    private Biblioteca() {

    }

    public static Biblioteca getInstance() {

        if (instance == null) {
            instance = new Biblioteca();
            instance.adicionarDados();
        }
        return instance;
    }

    public void reservar(String idUsuario, String idLivro) {

        Usuario reservaUsuario = EncontrarUsuarioPorId(idUsuario);
        Livro reservaLivro = encontrarLivroPorId(idLivro);
        String data = "aaaa";

        if (reservaUsuario != null && reservaLivro != null) {

            reservaUsuario.getReservaStrategy().reservar(reservaUsuario, reservaLivro, data);
        }

    }

    public void emprestar(String idUsuario, String idLivro) {

        Usuario emprestimoUsuario = EncontrarUsuarioPorId(idUsuario);
        Livro emprestimoLivro = encontrarLivroPorId(idLivro);

        if (emprestimoUsuario != null && emprestimoLivro != null) {

            emprestimoUsuario.getEmprestimoStrategy().emprestar(emprestimoUsuario, emprestimoLivro);
        }

    }

    private Usuario EncontrarUsuarioPorId(String id) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getCodigoIdentificacao().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    private Livro encontrarLivroPorId(String id) {
        for (Livro livro : this.livros) {
            if (livro.getCodigoIdentificacao().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    //// TESTES

    private void adicionarDados() {

        this.usuarios.add(new AlunoGraduacao("123", "João da Silva"));
        this.usuarios.add(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        this.usuarios.add(new AlunoGraduacao("789", "Pedro Paulo"));
        this.usuarios.add(new Professor("100", "Carlos Lucena"));

        this.livros.add(new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6ª", 2000));
        this.livros.add(new Livro("101", "UML – Guia do Usuário", "Campus",
                "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000));
        this.livros.add(new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", 2014));
        this.livros.add(new Livro("201", "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "Robert Martin", "1ª", 2002));
        this.livros.add(new Livro("300", "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999));
        this.livros.add(new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press",
                "Norman Fenton, James Bieman", "3ª", 2014));
        this.livros.add(new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", 1994));
        this.livros.add(new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "Martin Fowler", "3ª", 2003));

        Biblioteca.livros.get(0).adicionarExemplar(new Exemplar(Biblioteca.livros.get(0), "01"));

        // biblioteca.adicionarExemplar(new Exemplar(livro1, "01"));
        // biblioteca.adicionarExemplar(new Exemplar(livro1, "02"));
        // biblioteca.adicionarExemplar(new Exemplar(livro2, "03"));
        // biblioteca.adicionarExemplar(new Exemplar(livro3, "04"));
        // biblioteca.adicionarExemplar(new Exemplar(livro4, "05"));
        // biblioteca.adicionarExemplar(new Exemplar(livro5, "06"));
        // biblioteca.adicionarExemplar(new Exemplar(livro5, "07"));
        // biblioteca.adicionarExemplar(new Exemplar(livro7, "08"));
        // biblioteca.adicionarExemplar(new Exemplar(livro7, "09"));
    }

}