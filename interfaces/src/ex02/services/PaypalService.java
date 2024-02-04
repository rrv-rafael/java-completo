package ex02.services;

import ex02.entidades.Contrato;
import ex02.interfaces.IPagamentoService;

import java.time.LocalDate;

public class PaypalService implements IPagamentoService {
    @Override
    public double calcularJuros(double valor, int numeroParcela) {
        return valor * ((double) numeroParcela / 100);
    }
    @Override
    public double calcularTaxaPagamento(double valor) {
        return valor * 0.02;
    }
}
