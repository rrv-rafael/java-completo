package ex03.model.entidades;

import ex03.model.enums.Cor;
import ex03.model.interfaces.Forma;

public abstract class FormaAbstrata implements Forma {
    private Cor cor;

    public FormaAbstrata(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
