package ex02.interfaces;

public interface IPagamentoService {
    double calcularJuros(double valor, int numeroParcela);
    double calcularTaxaPagamento(double valor);
}
