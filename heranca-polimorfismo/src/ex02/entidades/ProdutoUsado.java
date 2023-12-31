package ex02.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto {
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dataFabricacao;

    public ProdutoUsado() {
    }

    public ProdutoUsado(String nome, Double preco, LocalDate dataManufatura) {
        super(nome, preco);
        this.dataFabricacao = dataManufatura;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaPreco() {
        return nome + " (usado) $" + String.format("%.2f", preco) + " (Data de fabricação: " + dataFabricacao.format(FORMATTER) + ")";
    }
}
