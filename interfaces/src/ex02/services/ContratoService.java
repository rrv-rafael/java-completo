package ex02.services;

import ex02.entidades.Contrato;
import ex02.entidades.Parcela;
import ex02.interfaces.IPagamentoService;

public class ContratoService {
    private final IPagamentoService pagamentoService;

    public ContratoService(IPagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public void processarContrato(Contrato contrato, int numeroParcelas) {
        double valorParcelaBasica = contrato.getValorTotal() / numeroParcelas;
        double valorParcelaJuros;
        double valorParcela;

        for (int i = 1; i <= numeroParcelas; i++) {
            valorParcelaJuros = valorParcelaBasica + pagamentoService.calcularJuros(valorParcelaBasica, i);
            valorParcela = valorParcelaJuros + pagamentoService.calcularTaxaPagamento(valorParcelaJuros);
            contrato.getParcelas().add(new Parcela(contrato.getData().plusMonths(i), valorParcela));
        }
    }
}