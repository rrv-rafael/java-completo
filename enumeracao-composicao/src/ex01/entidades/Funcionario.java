package ex01.entidades;

import ex01.entidades.enums.NivelFuncionario;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private NivelFuncionario nivel;
    private Double salarioBase;
    private List<Contrato> contrato;

    public Funcionario() {
    }

    public Funcionario(String nome, NivelFuncionario nivel, Double salarioBase) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.contrato = new ArrayList<>();
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
        this.contrato.add(contrato);
    }

    public void removerContrato(Contrato contrato) {

    }

    public Double rendimento(Integer ano, Integer mes) {
        double rendimentos = 0;

        for (Contrato c : contrato) {
            if (c.getDataContrato().getMonthValue() == mes && c.getDataContrato().getYear() == ano) {
                rendimentos += c.getHoras() * c.getValorPorHora();
            }
        }

        return rendimentos + salarioBase;
    }
}
