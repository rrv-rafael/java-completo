package exemploHeranca.entidades;

public class ContaEmpresarial extends Conta {
    private Double limiteEmprestimo;
    public ContaEmpresarial() {
        super();
    }

    public ContaEmpresarial(Integer numero, String titular, Double saldo, Double limiteEmprestimo) {
        super(numero, titular, saldo);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public Double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(Double limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void emprestimo(Double valorEmprestimo) {
        if (valorEmprestimo <= limiteEmprestimo) {
            saldo += valorEmprestimo - 10;
        }
    }

    @Override
    public void realizarSaque(double valorSaque) {
        super.realizarSaque(valorSaque);
        saldo -= 2;
    }
}
