package ex01.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Locadora {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    protected LocalDateTime dataRetirada;
    protected LocalDateTime dataDevolucao;
    private Veiculo modelo;
    private Fatura fatura;

    public Locadora(LocalDateTime dataRetirada, LocalDateTime dataDevolucao, Veiculo modelo) {
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.modelo = modelo;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Veiculo getModelo() {
        return modelo;
    }

    public void setModelo(Veiculo modelo) {
        this.modelo = modelo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
