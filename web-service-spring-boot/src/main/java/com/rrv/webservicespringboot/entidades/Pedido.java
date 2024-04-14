package com.rrv.webservicespringboot.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rrv.webservicespringboot.entidades.enums.PedidoStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPedido;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataPedido;

    private Integer pedidoStatus;

    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario cliente;

    @OneToMany(mappedBy = "codItemPedido.pedido")
    private final Set<ItemPedido> itemsPedido = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido() {
    }

    public Pedido(Long codPedido, Instant dataPedido, PedidoStatus pedidoStatus, Usuario cliente) {
        this.codPedido = codPedido;
        this.dataPedido = dataPedido;
        setPedidoStatus(pedidoStatus);
        this.cliente = cliente;
    }

    public Long getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Long codPedido) {
        this.codPedido = codPedido;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }

    public PedidoStatus getPedidoStatus() {
        return PedidoStatus.valueOf(pedidoStatus);
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        if (pedidoStatus != null) {
            this.pedidoStatus = pedidoStatus.getCodigo();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Set<ItemPedido> getItemsPedido() {
        return itemsPedido;
    }

    public void setPedidoStatus(Integer pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(codPedido, pedido.codPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codPedido);
    }
}
