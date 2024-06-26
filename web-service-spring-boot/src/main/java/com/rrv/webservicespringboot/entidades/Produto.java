package com.rrv.webservicespringboot.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;
    private String nome;
    private String descricao;
    private Double preco;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "produto_categoria", joinColumns = @JoinColumn(name = "codProduto"), inverseJoinColumns = @JoinColumn(name = "codCategoria"))
    private final Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "codItemPedido.produto")
    private final Set<ItemPedido> itemsPedido = new HashSet<>();

    public Produto() {
    }

    public Produto(Long codProduto, String nome, String descricao, Double preco, String imgUrl) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    @JsonIgnore
    public Set<Pedido> getPedidos() {
        Set<Pedido> set = new HashSet<>();

        for (ItemPedido itemPedido : itemsPedido) {
            set.add(itemPedido.getPedido());
        }

        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codProduto, produto.codProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codProduto);
    }
}
