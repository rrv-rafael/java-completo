package ex03.entidades;

import ex03.entidades.enums.StatusPedido;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private LocalDate dataPedido;
    private StatusPedido statusPedido;
    private Cliente cliente;
    private List<ItemPedido> itemPedidos;

    public Pedido() {
    }

    public Pedido(LocalDate dataPedido, StatusPedido statusPedido, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
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
}
