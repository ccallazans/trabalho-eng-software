package ReservarStrategy;

import Livro.Livro;
import Reserva.Reserva;
import Usuario.Usuario;

public class ReservaAlunoGraduacao implements ReservarStrategy {

    @Override
    public void reservar(Usuario usuario, Livro reservaLivro, String data) {
        // TODO Auto-generated method stub

        if (usuario.getReservas().size() >= 3) {
            /// mensagem
        } else {
            usuario.getReservas().add(new Reserva(reservaLivro, usuario));
        }
    }

}
