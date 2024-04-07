package com.rrv.webservicespringboot.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codUsuario;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public Usuario() {
    }

    public Usuario(Long codUsuario, String nome, String email, String telefone, String senha) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codUsuario, usuario.codUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codUsuario);
    }
}
