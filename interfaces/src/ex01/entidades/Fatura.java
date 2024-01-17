package ex01.entidades;

public class Fatura {
    private Double pagamentoBasico;
    private Double taxa;

    public Fatura(Double pagamentoBasico, Double taxa) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxa = taxa;
    }

    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public void setPagamentoBasico(Double pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public double getPagamentoTotal() {
        return getPagamentoBasico() + getTaxa();
    }
}
