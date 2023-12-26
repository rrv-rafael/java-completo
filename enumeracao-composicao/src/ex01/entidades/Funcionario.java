package ex01.entidades;

import ex01.entidades.enums.NivelFuncionario;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private NivelFuncionario nivel;
    private Double salarioBase;
    private Departamento departamento;
    private List<Contrato> contratos;

    public Funcionario() {
    }

    public Funcionario(String nome, NivelFuncionario nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
        this.contratos = new ArrayList<>();
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

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void addContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato) {
        this.contratos.remove(contrato);
    }

    public Double rendimento(Integer ano, Integer mes) {
        double rendimentos = salarioBase;

        for (Contrato c : contratos) {
            if (c.getDataContrato().getMonthValue() == mes && c.getDataContrato().getYear() == ano) {
                rendimentos += c.valorTotal();
            }
        }

        return rendimentos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nDepartamento: " + departamento.getNome();
    }
}
