package ex03.entidades;

public class ItemPedido {
    private Integer quantidade;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double subTotal() {
        return quantidade * produto.getPreco();
    }

    @Override
    public String toString() {
        return produto.getNome() + ", $" + String.format("%.2f", produto.getPreco()) + ", Quantidade: " + quantidade + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
