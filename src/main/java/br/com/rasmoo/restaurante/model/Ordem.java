package br.com.rasmoo.restaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordem")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "ordens")
    private List<OrdensCardapio> ordensCardapiosList = new ArrayList<>();
    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }


    public void addOrdemCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdens(this);
        this.ordensCardapiosList.add(ordensCardapio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataDeCriacao=" + dataDeCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
