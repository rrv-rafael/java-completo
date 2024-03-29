package model.entidades;

import java.util.Objects;

public class Departamento {
    private Integer codDepartamento;
    private String nome;

    public Departamento() {
    }

    public Departamento(Integer codDepartamento, String nome) {
        this.codDepartamento = codDepartamento;
        this.nome = nome;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(getCodDepartamento(), that.getCodDepartamento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodDepartamento());
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + codDepartamento +
                ", nome='" + nome + '\'' +
                '}';
    }
}
