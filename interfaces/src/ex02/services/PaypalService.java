package ex02.services;

import ex02.entidades.Contrato;
import ex02.interfaces.IPagamentoService;

import java.time.LocalDate;

public class PaypalService implements IPagamentoService {
    @Override
    public double calcularTaxaPagamento(double valor) {
        return valor + valor * 0.02;
    }

    @Override
    public double calcularJuros(double valor, int numeroParcela) {
        return valor + valor * (double) numeroParcela / 100;
    }
}
