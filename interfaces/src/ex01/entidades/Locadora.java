package ex01.entidades;

import ex01.interfaces.ILocadora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Locadora implements ILocadora {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String modeloVeiculo;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    private Double precoHora;
    private Double precoDia;

    public Locadora(String modeloVeiculo, LocalDateTime dataRetirada, LocalDateTime dataDevolucao, Double precoHora, Double precoDia) {
        this.modeloVeiculo = modeloVeiculo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.precoHora = precoHora;
        this.precoDia = precoDia;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
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

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public Double getPrecoDia() {
        return precoDia;
    }

    public void setPrecoDia(Double precoDia) {
        this.precoDia = precoDia;
    }

    @Override
    public double calcularPagamentoBasico() {
        int duracao;
        double pagamentoBasico = 0;

        if (dataRetirada.getDayOfMonth() == dataDevolucao.getDayOfMonth()) {
            duracao = dataDevolucao.getHour() - dataRetirada.getHour();

            if (duracao > 12) {
                return precoDia;
            }

            if (dataDevolucao.getMinute() > 1 || dataRetirada.getMinute() > 1) {
                pagamentoBasico += precoHora;
            }

            pagamentoBasico += duracao * precoHora;

            return pagamentoBasico;
        }

        duracao = dataDevolucao.getDayOfMonth() - dataRetirada.getDayOfMonth();

        if (dataDevolucao.getMinute() > 1 || dataRetirada.getMinute() > 1) {
            pagamentoBasico += precoDia;
        }

        pagamentoBasico += duracao * precoDia;
        return pagamentoBasico;
    }

    @Override
    public double calcularTaxa() {
        if (calcularPagamentoBasico() > 100) {
            return calcularPagamentoBasico() * 0.15;
        }

        return calcularPagamentoBasico() * 0.2;
    }

    @Override
    public String toString() {
        return "Pagamengo basico: " + String.format("%.2f", calcularPagamentoBasico()) +
               "\nTaxa: " + String.format("%.2f", calcularTaxa()) + "\nPagamento total: " + String.format("%.2f", calcularPagamentoBasico() + calcularTaxa());
    }
}
