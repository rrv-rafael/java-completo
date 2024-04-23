package com.rrv.webservicemongodb.dto;

import com.rrv.webservicemongodb.domain.Usuario;

import java.io.Serial;
import java.io.Serializable;

public class AutorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String codAutor;
    private String nome;

    public AutorDTO() {
    }

    public AutorDTO(Usuario usuario) {
        codAutor = usuario.getCodUsuario();
        nome = usuario.getNome();
    }

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String codAutor) {
        this.codAutor = codAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
