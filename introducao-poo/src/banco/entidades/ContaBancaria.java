package banco.entidades;

public class ContaBancaria {
    private final String numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public ContaBancaria(String numeroConta, String nomeTitular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        realizarDeposito(depositoInicial);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void realizarDeposito(double valorDeposito) {
        saldo += valorDeposito;
    }

    public void realizarSaque(double valorSaque) {
        saldo -= (valorSaque + 5);
    }

    @Override
    public String toString() {
        return "\n\nDados da Conta Bancária:" + "\nNúmero da conta: " + numeroConta + "\nNome do títular: " + nomeTitular + "\nSaldo: R$" + saldo;
    }
}
