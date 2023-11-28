package produto.entidades;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto() { }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double valorTotalEstoque() {
        return this.preco * this.quantidade;
    }

    public void adicionarProduto(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerProduto(int quantidade) {
        this.quantidade -= quantidade;
    }

    @Override
    public String toString() {
        return nome + ", R$" + String.format("%.2f", preco) + ", " + quantidade + " unidades. " + "Total: R$" + String.format("%.2f", valorTotalEstoque());
    }
}
