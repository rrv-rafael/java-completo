package CamadaXadrez;

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

    private void posicionarNovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.posicionarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
    }

    private void iniciarPartida() {
        posicionarNovaPeca('b', 6, new Torre(tabuleiro, Cor.WHITE));
        posicionarNovaPeca('e', 8, new Rei(tabuleiro, Cor.BLACK));
        posicionarNovaPeca('e', 1, new Rei(tabuleiro, Cor.WHITE));
    }
}
