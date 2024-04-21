package com.rrv.webservicemongodb.dto;

import com.rrv.webservicemongodb.domain.Usuario;

import java.io.Serial;
import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private String codUsuario;
    private String nome;
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        codUsuario = usuario.getCodUsuario();
        nome = usuario.getNome();
        email = usuario.getEmail();
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
}
