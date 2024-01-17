package ex01.services;

import ex01.interfaces.ITaxaService;

public class BrasilTaxaService implements ITaxaService {
    @Override
    public double taxa(double valor) {
        if (valor > 100) {
            return valor * 0.15;
        }

        return valor * 0.2;
    }
}
