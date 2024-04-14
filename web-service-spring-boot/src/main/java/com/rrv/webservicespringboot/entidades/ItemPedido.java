package com.rrv.webservicespringboot.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rrv.webservicespringboot.entidades.pk.ItemPedidoPK;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private final ItemPedidoPK codItemPedido = new ItemPedidoPK();

    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        codItemPedido.setPedido(pedido);
        codItemPedido.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return codItemPedido.getPedido();
    }

    public void setPedido(Pedido pedido) {
        codItemPedido.setPedido(pedido);
    }

    public Produto getProduto() {
        return codItemPedido.getProduto();
    }

    public void setProduto(Produto produto) {
        codItemPedido.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getSubTotal() {
        return preco * quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(codItemPedido, that.codItemPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codItemPedido);
    }
}
