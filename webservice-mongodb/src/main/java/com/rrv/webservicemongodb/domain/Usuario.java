package com.rrv.webservicemongodb.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID  = 1L;

    private Long codUsuario;
    private String nome;
    private String email;

    public Usuario() {
    }

    public Usuario(Long codUsuario, String nome, String email) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.email = email;
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
