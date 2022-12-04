package Biblioteca;

import java.util.ArrayList;

import Livro.Exemplar;
import Livro.Livro;
import Usuario.AlunoGraduacao;
import Usuario.AlunoPosGraduacao;
import Usuario.Professor;
import Usuario.Usuario;
import Reserva.Reserva;

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
        if (reservaUsuario == null) {
            System.out.println("Insucesso! Usuário não encontrado");
            return;
        }
        Livro reservaLivro = encontrarLivroPorId(idLivro);
        if (reservaLivro == null) {
            System.out.println("Insucesso! Livro não encontrado");
            return;
        }
        String data = "aaaa";

        if (reservaUsuario != null && reservaLivro != null) {

            reservaUsuario.getReservaStrategy().reservar(reservaUsuario, reservaLivro, data);
        }

    }

    public void emprestar(String idUsuario, String idLivro) {

        Usuario emprestimoUsuario = EncontrarUsuarioPorId(idUsuario);
        if (emprestimoUsuario == null) {
            System.out.println("Insucesso! Usuário não encontrado");
            return;
        }
        Livro emprestimoLivro = encontrarLivroPorId(idLivro);
        if (emprestimoLivro == null) {
            System.out.println("Insucesso! Livro não encontrado");
            return;
        }

        if (emprestimoUsuario != null && emprestimoLivro != null) {
            System.out.println("encontrou");
            emprestimoUsuario.getEmprestimoStrategy().emprestar(emprestimoUsuario, emprestimoLivro);
        }
    }

    public void devolver(String idUsuario, String idLivro) {

        Usuario devolverEmprestimoUsuario = EncontrarUsuarioPorId(idUsuario);
        if (devolverEmprestimoUsuario == null) {
            System.out.println("Insucesso! Usuário não encontrado");
            return;
        }
        Livro devolverEmprestimoLivro = encontrarLivroPorId(idLivro);
        if (devolverEmprestimoLivro == null) {
            System.out.println("Insucesso! Livro não encontrado");
            return;
        }

        devolverEmprestimoUsuario.getDevolverStrategy().devolver(devolverEmprestimoUsuario, devolverEmprestimoLivro);

    }

    public void observar(String idUsuario, String idLivro) {
        Usuario usuario = EncontrarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Insucesso! Usuário não encontrado");
            return;
        }
        Livro livro = encontrarLivroPorId(idLivro);
        if (usuario == null) {
            System.out.println("Insucesso! Livro não encontrado");
            return;
        }

        if (usuario != null && livro != null) {
            livro.registerObserver(usuario);
            System.out.println("Sucesso!");
        }
    }

    public void consultarLivro(String idLivro) {

        Livro livro = encontrarLivroPorId(idLivro);
        if (livro == null) {
            System.out.println("Insucesso! Livro não encontrado");
            return;
        }
        int qntReservas = livro.getReservas().size();

        System.out.println("Título: " + livro.getTitulo() +
                "\nQnt Reservas: " + qntReservas);

        if (qntReservas > 0) {
            System.out.println("Reservas - Informações:");
            for (Reserva reserva: livro.getReservas()) {
                System.out.println(reserva.getUsuario().getNome());
            }
        }

        int qntExemplar = livro.getExemplares().size();
        if (qntExemplar > 0) {
            System.out.println("Exemplar - Informações:");
            for (Exemplar exemplar: livro.getExemplares()) {
                System.out.println("Codigo: " + exemplar.getCodigoExemplar() +
                        "\nStatus: " + exemplar.getStatusString());
                if (!exemplar.getEstado().status) {
                    System.out.println("Usuario: " + exemplar.getUltimoEmprestimo().getUsuario().getNome() +
                    "\nData de Empréstimo: " + exemplar.getUltimoEmprestimo().getDataEmprestimo() +
                            "\nData de Devolução: " + exemplar.getUltimoEmprestimo().getDataDevolucao());
                }
            }
        }

    }

    public void consultarUsuario(String id) {
        Usuario usuario = this.EncontrarUsuarioPorId(id);
        if (usuario == null) {
            System.out.println("Insucesso! Usuário não encontrado");
            return;
        }
        usuario.consultar();
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

    public void consultaProfessor(String id) {
        Usuario usuario = EncontrarUsuarioPorId(id);
        if (usuario == null) {
            System.out.println("Insucesso! Usuário não encontrado");
            return;
        }
        usuario.consulta();
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
        Biblioteca.livros.get(0).adicionarExemplar(new Exemplar(Biblioteca.livros.get(0), "02"));
        Biblioteca.livros.get(1).adicionarExemplar(new Exemplar(Biblioteca.livros.get(1), "03"));
        Biblioteca.livros.get(2).adicionarExemplar(new Exemplar(Biblioteca.livros.get(2), "04"));
        Biblioteca.livros.get(3).adicionarExemplar(new Exemplar(Biblioteca.livros.get(3), "05"));
        Biblioteca.livros.get(4).adicionarExemplar(new Exemplar(Biblioteca.livros.get(4), "06"));
        Biblioteca.livros.get(4).adicionarExemplar(new Exemplar(Biblioteca.livros.get(4), "07"));
        Biblioteca.livros.get(6).adicionarExemplar(new Exemplar(Biblioteca.livros.get(6), "08"));
        Biblioteca.livros.get(6).adicionarExemplar(new Exemplar(Biblioteca.livros.get(6), "09"));

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