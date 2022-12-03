package ReservarStrategy;

import Livro.Livro;
import Reserva.Reserva;
import Usuario.Usuario;

public class ReservaAlunoPosGraduacao implements ReservarStrategy {

    @Override
    public void reservar(Usuario usuario, Livro reservaLivro, String data) {
        String mensagem;

        if (usuario.getReservas().size() >= 3) {
            /// mensagem
            mensagem = "Insucesso! Usuário atingiu o número máximo de reservas.";
        } else {
            mensagem = "Sucesso! Reserva adicionada.";

            reservaLivro.getReservas().add(new Reserva(reservaLivro, usuario));
            usuario.getReservas().add(new Reserva(reservaLivro, usuario));
        }

        System.out.println("Usuário: " + usuario.getNome() +
                "\nTítulo: " + reservaLivro.getTitulo() +
                "\nMensagem: " + mensagem);
    }

}
