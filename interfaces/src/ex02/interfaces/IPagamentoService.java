package ex02.interfaces;

public interface IPagamentoService {
    double calcularJuros(double valor, int numeroParcelas);
    double calcularTaxaPagamento(double valor);
}
