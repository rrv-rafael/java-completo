package exemploHeranca.app;

import exemploHeranca.entidades.Conta;
import exemploHeranca.entidades.ContaEmpresarial;
import exemploHeranca.entidades.ContaPoupanca;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta(1001, "Alex", 0.0);

        ContaEmpresarial contaEmpresarial = new ContaEmpresarial(1002, "Maria", 0.0, 500.0);

        // UPCASTING:
        Conta conta1 = contaEmpresarial;
        Conta conta2 = new ContaEmpresarial(1003, "Bob", 0.0, 200.0);
        Conta conta3 = new ContaPoupanca(1004, "Ana", 0.0, 0.01);

        // DOWNCASTING
        ContaEmpresarial conta4 = (ContaEmpresarial) conta2;
        conta4.emprestimo(100.0);

        //ContaEmpresarial conta5 = (ContaEmpresarial) conta3;

        if (conta3 instanceof ContaEmpresarial) {
            ContaEmpresarial conta5 = (ContaEmpresarial) conta3;
            conta5.emprestimo(200.0);
            System.out.println("Emprestado.");
        }

        if (conta3 instanceof ContaPoupanca) {
            ContaPoupanca conta5 = (ContaPoupanca) conta3;
            conta5.atualizarSaldo();
            System.out.println("Atualizado.");
        }
    }
}