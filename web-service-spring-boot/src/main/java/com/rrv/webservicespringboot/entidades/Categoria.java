package com.rrv.webservicespringboot.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Categoria implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCategoria;
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private final Set<Produto> produtos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Long codCategoria, String nome) {
        this.codCategoria = codCategoria;
        this.nome = nome;
    }

    public Long getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Long codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(codCategoria, categoria.codCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codCategoria);
    }
}
