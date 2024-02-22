package ex05.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String nomeUsuario;
    private LocalDateTime instanteAcesso;

    public Log(String nomeUsuario, LocalDateTime instanteAcesso) {
        this.nomeUsuario = nomeUsuario;
        this.instanteAcesso = instanteAcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDateTime getInstanteAcesso() {
        return instanteAcesso;
    }

    public void setInstanteAcesso(LocalDateTime instanteAcesso) {
        this.instanteAcesso = instanteAcesso;
    }

    @Override
    public String toString() {
        return nomeUsuario + " - " + FORMATTER.format(instanteAcesso);
    }
}
