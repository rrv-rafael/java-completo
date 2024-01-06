package CamadaTabuleiro;

public class Tabuleiro {
    private int quantidadeLinha;
    private int quantidadeColuna;
    private Peca[][] pecas;

    public Tabuleiro(int quantidadeLinha, int quantidadeColuna) {
        if (quantidadeLinha < 1 || quantidadeColuna < 1) {
            throw new TabuleiroExcecao("Erro ao criar o tabuleiro: É necessário que haja pelo menos uma linha e uma coluna.");
        }
        this.quantidadeLinha = quantidadeLinha;
        this.quantidadeColuna = quantidadeColuna;
        pecas = new Peca[quantidadeLinha][quantidadeColuna];
    }

    public int getQuantidadeLinha() {
        return quantidadeLinha;
    }

    public int getQuantidadeColuna() {
        return quantidadeColuna;
    }

    public Peca peca(int linha, int coluna) {
        if (!posicaoExiste(linha, coluna)) {
            throw new TabuleiroExcecao("Posição não existe no tabuleiro.");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroExcecao("Posição não existe no tabuleiro.");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void posicionarPeca(Peca peca, Posicao posicao) {
        if (existePeca(posicao)) {
            throw new TabuleiroExcecao("Já existe uma peça na posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private boolean posicaoExiste(int linha, int coluna) {
        return linha >= 0 && linha < quantidadeLinha && coluna >= 0 && coluna < quantidadeColuna;
    }
    public boolean posicaoExiste(Posicao posicao) {
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean existePeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new TabuleiroExcecao("Posição não existe no tabuleiro.");
        }
        return peca(posicao) != null;
    }
}
