package ex05.model.services;

import ex05.model.interfaces.IJurosService;

public class UsaJurosService implements IJurosService {
    private Double taxaJuros;

    public UsaJurosService(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public Double getTaxaJuros() {
        return taxaJuros;
    }
}
