package ex05.entidades;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Log {
    private String nomeUsuario;
    private Instant instanteAcesso;

    public Log(String nomeUsuario, Instant instanteAcesso) {
        this.nomeUsuario = nomeUsuario;
        this.instanteAcesso = instanteAcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Instant getInstanteAcesso() {
        return instanteAcesso;
    }

    public void setInstanteAcesso(Instant instanteAcesso) {
        this.instanteAcesso = instanteAcesso;
    }
}
