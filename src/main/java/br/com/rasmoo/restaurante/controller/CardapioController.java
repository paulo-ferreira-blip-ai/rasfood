package br.com.rasmoo.restaurante.controller;

import br.com.rasmoo.restaurante.model.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioController {

    private EntityManager entityManager;

    public CardapioController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos() {
        try {
            String sql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarPorvalor(final BigDecimal filtro) {

        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cardapio consultarPorNome(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public Cardapio atualizar(final Cardapio cardapio) {
        return this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
