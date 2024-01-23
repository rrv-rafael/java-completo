package ex02.entidades;

import ex02.services.PaypalService;

import java.time.LocalDate;

public class Contrato {
    private Integer numero;
    private LocalDate data;
    private Double valorTotal;
    private PaypalService paypalService;

    public Contrato(Integer numero, LocalDate data, Double valorTotal, PaypalService paypalService) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
        this.paypalService = paypalService;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PaypalService getPaypalService() {
        return paypalService;
    }

    public void setPaypalService(PaypalService paypalService) {
        this.paypalService = paypalService;
    }
}
