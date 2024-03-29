package model.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Vendedor {
    private Integer codVendedor;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private Double baseSalarial;

    private Departamento departamento;

    public Vendedor(Integer codVendedor, String nome, String email, LocalDate dataNascimento, Double baseSalarial, Departamento departamento) {
        this.codVendedor = codVendedor;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.baseSalarial = baseSalarial;
        this.departamento = departamento;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getBaseSalarial() {
        return baseSalarial;
    }

    public void setBaseSalarial(Double baseSalarial) {
        this.baseSalarial = baseSalarial;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(codVendedor, vendedor.codVendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codVendedor);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "codVendedor=" + codVendedor +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", baseSalarial=" + baseSalarial +
                ", departamento=" + departamento +
                '}';
    }
}
