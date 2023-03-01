package br.com.rasmoo.restaurante.model;

import javax.persistence.*;

@Entity

@Table(name = "clientes")
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    private String cep;


    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
