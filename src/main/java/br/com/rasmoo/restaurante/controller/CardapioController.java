package br.com.rasmoo.restaurante.controller;

import br.com.rasmoo.restaurante.model.Cardapio;

import javax.persistence.EntityManager;

public class CardapioController {

    private EntityManager entityManager;

    public CardapioController(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio){
       this.entityManager.persist(cardapio);
    }

    public Cardapio consultar(final Integer id){
       return this.entityManager.find(Cardapio.class,id);
    }

    public Cardapio atualizar(final Cardapio cardapio){
        return this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
