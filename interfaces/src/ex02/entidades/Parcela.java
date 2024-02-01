package ex02.entidades;

import java.time.LocalDate;

public class Parcela {
    private LocalDate dataPagamento;
    private Double valor;

    public Parcela(LocalDate dataPagamento, Double valor) {
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
