package ex05.model.entidades;

public class Emprestimo {
    private Double quantia;
    private Integer duracao;
    
    public Emprestimo(Double quantia, Integer duracao) {
        this.quantia = quantia;
        this.duracao = duracao;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
