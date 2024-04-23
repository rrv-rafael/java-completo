package com.rrv.webservicemongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID  = 1L;

    @Id
    private String codUsuario;
    private String nome;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String codUsuario, String nome, String email) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.email = email;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
