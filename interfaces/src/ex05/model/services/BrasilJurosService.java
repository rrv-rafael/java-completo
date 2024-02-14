package ex05.model.services;

import ex05.model.interfaces.IJurosService;

public class BrasilJurosService implements IJurosService {
    private double taxaJuros;

    public BrasilJurosService(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public Double getTaxaJuros() {
        return taxaJuros;
    }
}