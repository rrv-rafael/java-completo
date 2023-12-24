package ex01.entidades;

import ex01.entidades.enums.NivelFuncionario;

public class Funcionario {
    private String nome;
    private NivelFuncionario nivel;
    private Double salarioBase;

    public Funcionario() {
    }

    public Funcionario(String nome, NivelFuncionario nivel, Double salarioBase) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelFuncionario getNivel() {
        return nivel;
    }

    public void setNivel(NivelFuncionario nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void addContrato(Contrato contrato) {

    }

    public void removerContrato(Contrato contrato) {

    }

    public Double receita(Integer ano, Integer mes) {
        return 0.0;
    }
}
