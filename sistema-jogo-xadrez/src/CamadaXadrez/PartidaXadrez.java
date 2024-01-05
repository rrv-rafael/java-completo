package CamadaXadrez;

import CamadaTabuleiro.Posicao;
import CamadaTabuleiro.Tabuleiro;
import CamadaXadrez.PecasXadrez.Rei;
import CamadaXadrez.PecasXadrez.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        iniciarPartida();
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] pecasXadrez = new PecaXadrez[tabuleiro.getQuantidadeLinha()][tabuleiro.getQuantidadeColuna()];

        for (int i = 0; i < tabuleiro.getQuantidadeLinha(); i++) {
            for (int j = 0; j < tabuleiro.getQuantidadeColuna(); j++) {
                pecasXadrez[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }

        return pecasXadrez;
    }

    private void iniciarPartida() {
        tabuleiro.posicionarPeca(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
        tabuleiro.posicionarPeca(new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
        tabuleiro.posicionarPeca(new Rei(tabuleiro, Cor.WHITE), new Posicao(7, 4));
    }
}
