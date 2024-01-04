package ex02.model.entidades;

import ex02.model.excecoes.DominioExcecao;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void depositar(double valorDeposito) {
        saldo += valorDeposito;
    }

    public void sacar(double valorSaque) {
        validarSaque(valorSaque);
        saldo -= valorSaque;
    }

    private void validarSaque(double valorSaque) {
        if (valorSaque > limiteSaque) {
            throw new DominioExcecao("O valor excede o limite de saque.");
        }

        if (valorSaque > saldo) {
            throw new DominioExcecao("Saldo insucifiente.");
        }
    }
}