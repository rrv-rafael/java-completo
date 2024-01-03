package ex01.model.entidades;

import ex01.model.excecoes.DominioExcecao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Integer numeroQuarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(Integer numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        verificarDatas(dataEntrada, dataSaida);

        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer duracao() {
        return dataSaida.getDayOfMonth() - dataEntrada.getDayOfMonth();
    }
    public void atualizarData(LocalDate dataEntrada, LocalDate dataSaida) {
        verificarDatas(dataEntrada, dataSaida);

        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public void verificarDatas(LocalDate dataEntrada, LocalDate dataSaida) {
        LocalDate dataAtual = LocalDate.now();

        if (dataEntrada.isBefore(dataAtual) || dataSaida.isBefore(dataAtual)) {
            throw new DominioExcecao("A data das reservas para atualização devem ser futuras.");
        } else if (dataEntrada.isAfter(dataSaida)) {
            throw new DominioExcecao("Data de saída deve ser posterior a data de entrada.");
        }
    }

    @Override
    public String toString() {
        return "Reserva: " +
               "Quarto " + numeroQuarto +
               ", Data de entrada: " + dataEntrada.format(FORMATTER) +
               ", Data de saída: " + dataSaida.format(FORMATTER) +
               ", " + duracao() + " noites";
    }
}
