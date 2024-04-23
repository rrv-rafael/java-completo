package com.rrv.webservicemongodb.domain;

import com.rrv.webservicemongodb.dto.AutorDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Document
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String codPost;
    private LocalDate data;
    private String titulo;
    private String corpo;

    private AutorDTO autor;

    public Post() {
    }

    public Post(String codPost, LocalDate data, String titulo, String corpo, AutorDTO autor) {
        this.codPost = codPost;
        this.data = data;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

    public String getCodPost() {
        return codPost;
    }

    public void setCodPost(String codPost) {
        this.codPost = codPost;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(codPost, post.codPost);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codPost);
    }
}
