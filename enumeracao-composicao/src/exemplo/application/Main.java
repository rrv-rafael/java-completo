package exemplo.application;

import exemplo.entidades.Pedido;
import exemplo.entidades.enums.StatusPedido;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1080, new Date(), StatusPedido.AGUARDANDO_PAGAMENTO);

        System.out.println(pedido);

        StatusPedido statusPedido = StatusPedido.ENTREGUE;

        StatusPedido statusPedido1 = StatusPedido.valueOf("ENTREGUE");

        System.out.println(statusPedido);
        System.out.println(statusPedido1);
    }
}