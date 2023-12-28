package ex03.entidades;

import ex03.entidades.enums.StatusPedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private Cliente cliente;
    private List<ItemPedido> itemsPedido;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Pedido() {
    }

    public Pedido(LocalDateTime dataPedido, StatusPedido statusPedido, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.itemsPedido = new ArrayList<>();
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        itemsPedido.add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        itemsPedido.remove(itemPedido);
    }

    public double total() {
        double soma = 0;

        for (ItemPedido i : itemsPedido) {
            soma += i.subTotal();
        }

        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nRESUMO DO PEDIDO:\n").append("Data do pedido: ").append(dataPedido.format(FORMATTER))
                .append("\nStatus do pedido: ").append(statusPedido)
                .append("\nCliente: ").append(cliente).append("\nItems do pedido:\n");

        for (ItemPedido i : itemsPedido) {
            sb.append(i).append("\n");
        }

        sb.append("Preço total: $").append(String.format("%.2f", total()));

        return sb.toString();
    }
}
