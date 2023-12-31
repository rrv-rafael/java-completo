package ex02.entidades;

public class ProdutoImportato extends Produto {
    private Double taxaAlfandega;

    public ProdutoImportato() {
    }

    public ProdutoImportato(String nome, Double preco, Double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(Double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    @Override
    public String etiquetaPreco() {
        return nome + " $" + String.format("%.2f", precoTotal()) + " (Taxa da alfândega: $" + String.format("%.2f", taxaAlfandega) + ")";
    }

    public double precoTotal() {
        return preco + taxaAlfandega;
    }
}
