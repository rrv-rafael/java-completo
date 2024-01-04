package CamadaXadrez;

import CamadaTabuleiro.Peca;
import CamadaTabuleiro.Tabuleiro;

public class PecaXadrez extends Peca {
    private final Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
}
