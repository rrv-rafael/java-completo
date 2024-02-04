package ex02.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final LocalDate dataPagamento;
    private final Double valor;

    public Parcela(LocalDate dataPagamento, Double valor) {
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return dataPagamento.format(FORMATTER)  + " - " + valor;
    }
}
