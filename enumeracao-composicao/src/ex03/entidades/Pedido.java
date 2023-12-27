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
    private List<ItemPedido> itemPedidos;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Pedido() {
    }

    public Pedido(LocalDateTime dataPedido, StatusPedido statusPedido, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.itemPedidos = new ArrayList<>();
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

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        this.itemPedidos.add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        this.itemPedidos.remove(itemPedido);
    }

    public Double total() {
        double soma = 0;

        for (ItemPedido i : itemPedidos) {
            soma += i.subTotal();
        }

        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Data do pedido: ").append(dataPedido.format(FORMATTER))
                .append("\nStatus do pedido: ").append(statusPedido)
                .append("\nCliente: ").append(cliente).append("\nItems do pedido:\n");

        for (ItemPedido i : itemPedidos) {
            sb.append(i).append("\n");
        }

        return sb.toString();
    }
}
