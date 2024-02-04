package ex02.services;

import ex02.entidades.Contrato;
import ex02.entidades.Parcela;
import ex02.interfaces.IPagamentoService;

public class ContratoService {
    public void processarContrato(Contrato contrato, int numeroParcelas) {
        IPagamentoService pagamentoService = new PaypalService();
        double valorParcela = contrato.getValorTotal() / numeroParcelas;
        double valorParcelaJuros;
        double valorParcelaCalculada;

        for (int i = 1; i <= numeroParcelas; i++) {
            valorParcelaJuros = valorParcela + pagamentoService.calcularJuros(valorParcela, i);
            valorParcelaCalculada = valorParcelaJuros + pagamentoService.calcularTaxaPagamento(valorParcelaJuros);
            contrato.getParcelas().add(new Parcela(contrato.getData().plusMonths(i), valorParcelaCalculada));
        }
    }
}