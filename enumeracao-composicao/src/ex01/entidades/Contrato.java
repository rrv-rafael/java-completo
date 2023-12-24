package ex01.entidades;

import java.util.Date;

public class Contrato {
    private Date dataContrato;
    private Double valorPorHora;
    private Integer horas;

    public Contrato() {
    }

    public Contrato(Date dataContrato, Double valorPorHora, Integer horas) {
        this.dataContrato = dataContrato;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
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
}
