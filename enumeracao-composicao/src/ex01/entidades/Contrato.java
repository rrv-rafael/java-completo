package ex01.entidades;

import java.time.LocalDate;
import java.util.Date;

public class Contrato {
    private LocalDate dataContrato;
    private Double valorPorHora;
    private Integer horas;

    public Contrato() {
    }

    public Contrato(LocalDate dataContrato, Double valorPorHora, Integer horas) {
        this.dataContrato = dataContrato;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Double valorTotal() {
        return 0.0;
    }
}
