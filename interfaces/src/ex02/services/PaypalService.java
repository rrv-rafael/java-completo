package ex02.services;

import ex02.entidades.Contrato;
import ex02.interfaces.IPagamentoService;

import java.time.LocalDate;

public class PaypalService implements IPagamentoService {
    @Override
    public double calcularPagamentoMensal(double valorParcela, int numeroParcela) {
        valorParcela += valorParcela * (double) numeroParcela / 100;
        valorParcela += valorParcela * 0.02;

        return valorParcela;
    }
}
