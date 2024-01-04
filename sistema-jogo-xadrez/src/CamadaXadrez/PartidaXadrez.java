package CamadaXadrez;

import CamadaTabuleiro.Tabuleiro;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
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
}
