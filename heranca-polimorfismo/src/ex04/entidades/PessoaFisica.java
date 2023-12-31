package ex04.entidades;

public class PessoaFisica extends Pessoa {
    private Double gastosSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calcularImposto() {
        double impostoAbatido = gastosSaude * 0.5;

        return getRendaAnual() < 20000 ? (getRendaAnual() * 0.15) - impostoAbatido : (getRendaAnual() * 0.25) - impostoAbatido;
    }
}
