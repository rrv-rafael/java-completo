package exemploHeranca.app;

import exemploHeranca.entidades.Conta;
import exemploHeranca.entidades.ContaEmpresarial;
import exemploHeranca.entidades.ContaPoupanca;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta(1001, "Alex", 1000.0);
        conta.realizarSaque(200.0);

        System.out.println(conta.getSaldo());

        Conta contaPoupanca = new ContaPoupanca(1002, "Maria", 1000.0, 0.01);
        contaPoupanca.realizarSaque(200.0);

        System.out.println(contaPoupanca.getSaldo());

        Conta contaEmpresarial = new ContaEmpresarial(1003, "Bob", 1000.0, 500.0);
        contaEmpresarial.realizarSaque(200.0);

        System.out.println(contaEmpresarial.getSaldo());
    }
}