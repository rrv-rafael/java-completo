package CamadaTabuleiro;

public class Tabuleiro {
    private int quantidadeLinha;
    private int quantidadeColuna;
    private Peca[][] pecas;

    public Tabuleiro(int quantidadeLinha, int quantidadeColuna) {
        this.quantidadeLinha = quantidadeLinha;
        this.quantidadeColuna = quantidadeColuna;
        pecas = new Peca[quantidadeLinha][quantidadeColuna];
    }

    public int getQuantidadeLinha() {
        return quantidadeLinha;
    }

    public void setQuantidadeLinha(int quantidadeLinha) {
        this.quantidadeLinha = quantidadeLinha;
    }

    public int getQuantidadeColuna() {
        return quantidadeColuna;
    }

    public void setQuantidadeColuna(int quantidadeColuna) {
        this.quantidadeColuna = quantidadeColuna;
    }

    public Peca peca(int linha, int coluna) {
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
}
