package ex05.model.interfaces;

import java.security.InvalidParameterException;

public interface IJurosService {
    Double getTaxaJuros();
    default double pagamento(double quantia, int meses) {
        if (meses < 1) {
            throw new InvalidParameterException("A quantidade de meses deve ser maior que zero.");
        }

        return quantia * Math.pow(1 + getTaxaJuros() / 100, meses);
    }
}
