package ex01.services;

import ex01.entidades.Fatura;
import ex01.entidades.Locadora;
import ex01.interfaces.ITaxaService;

import java.time.Duration;

public class LocadoraService {
    private Double precoHora;
    private Double precoDia;
    private ITaxaService brasilTaxaService;

    public LocadoraService(Double precoHora, Double precoDia, ITaxaService taxaService) {
        this.precoHora = precoHora;
        this.precoDia = precoDia;
        this.brasilTaxaService = taxaService;
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

    public ITaxaService getBrasilTaxaService() {
        return brasilTaxaService;
    }

    public void setBrasilTaxaService(ITaxaService brasilTaxaService) {
        this.brasilTaxaService = brasilTaxaService;
    }

    public void processarFatura(Locadora locadora) {
        double minutos = Duration.between(locadora.getDataRetirada(), locadora.getDataDevolucao()).toMinutes();
        double horas = minutos / 60;

        double pagamentoBasico;

        if (horas > 12) {
            pagamentoBasico = precoDia * Math.ceil(horas / 24);
        } else {
            pagamentoBasico = precoHora * Math.ceil(horas);
        }

        locadora.setFatura(new Fatura(pagamentoBasico, brasilTaxaService.taxa(pagamentoBasico)));
    }
}
