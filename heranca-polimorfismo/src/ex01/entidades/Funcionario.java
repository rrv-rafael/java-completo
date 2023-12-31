package ex01.entidades;

public class Funcionario {
    protected String nome;
    private Integer horasTrabalhadas;
    private Double valorPorHora;

    public Funcionario() {
    }

    public Funcionario(String nome, Integer horas, Double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horas;
        this.valorPorHora = valorPorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public double pagamento() {
        return valorPorHora * horasTrabalhadas;
    }

    @Override
    public String toString() {
        return nome + " - $ " + String.format("%.2f", pagamento());
    }
}
