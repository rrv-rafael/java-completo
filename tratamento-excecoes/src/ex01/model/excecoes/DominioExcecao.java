package ex01.model.excecoes;

public class DominioExcecao extends RuntimeException {
    public DominioExcecao(String mensagem) {
        super(mensagem);
    }
}
