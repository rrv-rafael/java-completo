package com.rrv.webservicemongodb.domain;

import com.rrv.webservicemongodb.dto.AutorDTO;
import com.rrv.webservicemongodb.dto.ComentarioDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String codPost;
    private LocalDate dataPost;
    private String titulo;
    private String corpo;

    private AutorDTO autor;
    private List<ComentarioDTO> comentariosDTO = new ArrayList<>();

    public Post() {
    }

    public Post(String codPost, LocalDate dataPost, String titulo, String corpo, AutorDTO autor) {
        this.codPost = codPost;
        this.dataPost = dataPost;
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

    public LocalDate getDataPost() {
        return dataPost;
    }

    public void setdataPost(LocalDate dataPost) {
        this.dataPost = dataPost;
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

    public List<ComentarioDTO> getComentariosDTO() {
        return comentariosDTO;
    }

    public void setComentariosDTO(List<ComentarioDTO> comentariosDTO) {
        this.comentariosDTO = comentariosDTO;
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
