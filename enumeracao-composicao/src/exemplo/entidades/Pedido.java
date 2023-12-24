package exemplo.entidades;

import exemplo.entidades.enums.StatusPedido;

import java.util.Date;

public class Pedido {
    private Integer id;
    private Date dataPedido;
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Integer id, Date dataPedido, StatusPedido status) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dados do Pedido:\n" +
                "Id: " + id +
                "\nData do Pedido: " + dataPedido +
                "\nStatus: " + status;
    }
}
