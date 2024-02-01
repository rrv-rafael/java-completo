package ex02.interfaces;

public interface IPagamentoService {
    double calcularTaxaPagamento(double valor);
    double calcularJuros(double valor, int numeroParcelas);
}
