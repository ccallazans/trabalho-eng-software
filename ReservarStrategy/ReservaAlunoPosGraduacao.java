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
        } else if (usuario.hasReservaByIdLivro(reservaLivro.getCodigoIdentificacao())) {
            mensagem = "Insucesso! Usuário já possui reserva desse livro.";
        } else {
            mensagem = "Sucesso! Reserva adicionada.";

            Reserva novaReserva = new Reserva(reservaLivro, usuario);

            reservaLivro.getReservas().add(novaReserva);

            usuario.getReservas().add(novaReserva);
            usuario.getAllReservas().add(novaReserva);

            if (reservaLivro.getReservas().size() >= 2) {
                reservaLivro.notifyObservers();
            }
        }

        System.out.println("Usuário: " + usuario.getNome() +
                "\nTítulo: " + reservaLivro.getTitulo() +
                "\nMensagem: " + mensagem);
    }

}
