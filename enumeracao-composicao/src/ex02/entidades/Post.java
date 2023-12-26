package ex02.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private LocalDateTime momento;
    private String titulo;
    private String conteudo;
    private Integer qtdCurtidas;
    private List<Comentario> comentarios;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Post() {
    }

    public Post(LocalDateTime momento, String titulo, String conteudo, Integer qtdCurtidas) {
        this.momento = momento;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.qtdCurtidas = qtdCurtidas;
        comentarios = new ArrayList<>();
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getQtdCurtidas() {
        return qtdCurtidas;
    }

    public void setQtdCurtidas(Integer qtdCurtidas) {
        this.qtdCurtidas = qtdCurtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(titulo).append("\n")
                .append(qtdCurtidas).append(" Curtidas - ")
                .append(momento.format(FORMATTER)).append("\n")
                .append(conteudo)
                .append("\nComentários:\n");

        for (Comentario c : comentarios) {
            sb.append(c.getConteudo()).append("\n");
        }

        return sb.toString();
    }
}
