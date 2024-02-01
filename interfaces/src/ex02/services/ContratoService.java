package ex02.services;

import ex02.entidades.Contrato;
import ex02.entidades.Parcela;
import ex02.interfaces.IPagamentoService;

public class ContratoService {
    public void processarContrato(Contrato contrato, int numeroParcelas) {
        IPagamentoService pagamentoService = new PaypalService();
        double valorParcela = contrato.getValorTotal() / numeroParcelas;
        double valorTaxaCalculada;

        for (int i = 1; i <= numeroParcelas; i++) {
            valorTaxaCalculada = pagamentoService.calcularTaxaPagamento(valorParcela);
            contrato.getParcelas().add(new Parcela(contrato.getData().plusMonths(i), pagamentoService.calcularJuros(valorTaxaCalculada, i)));
        }
    }
}
