package exemploHeranca.app;

import exemploHeranca.entidades.Conta;
import exemploHeranca.entidades.ContaEmpresarial;

public class App {
    public static void main(String[] args) {
        ContaEmpresarial contaEmpresarial = new ContaEmpresarial(1, "Rafael", 10.0, 100.0);

        contaEmpresarial.realizarDeposito(2);
        double saldo = contaEmpresarial.getSaldo();

        System.out.println(saldo);
    }
}