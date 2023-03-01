package br.com.rasmoo.restaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Ordem ordens;
    @ManyToOne
    private Cardapio cardapio;

    private BigDecimal valor;

    private Integer quantidade;

    public OrdensCardapio(Ordem ordens, Cardapio cardapio, Integer quantidade) {
        this.ordens = ordens;
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valor = cardapio.getValor();//passando o valor diretamente da classe
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ordem getOrdens() {
        return ordens;
    }

    public void setOrdens(Ordem ordens) {
        this.ordens = ordens;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OrdensCardapio{" +
                "id=" + id +
                ", ordens=" + ordens +
                ", cardapio=" + cardapio +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
