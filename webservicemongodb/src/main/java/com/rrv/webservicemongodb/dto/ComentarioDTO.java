package com.rrv.webservicemongodb.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class ComentarioDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String texto;
    private LocalDate data;
    private AutorDTO autorDTO;

    public ComentarioDTO() {
    }

    public ComentarioDTO(String texto, LocalDate data, AutorDTO autorDTO) {
        this.texto = texto;
        this.data = data;
        this.autorDTO = autorDTO;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public AutorDTO getAutorDTO() {
        return autorDTO;
    }

    public void setAutorDTO(AutorDTO autorDTO) {
        this.autorDTO = autorDTO;
    }
}
