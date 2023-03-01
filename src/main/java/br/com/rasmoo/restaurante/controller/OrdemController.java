package br.com.rasmoo.restaurante.controller;

import br.com.rasmoo.restaurante.model.Ordem;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OrdemController {

    private EntityManager entityManager;

    public OrdemController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultarPorId(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos() {
        try {
            String sql = "SELECT c FROM Ordem c";
            return this.entityManager.createQuery(sql, Ordem.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Ordem> consultarPorvalor(final BigDecimal filtro) {

        try {
            String jpql = "SELECT c FROM Ordem c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Ordem.class).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Ordem consultarPorNome(final String filtro) {
        try {
            String jpql = "SELECT c FROM Ordem c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Ordem.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public Ordem atualizar(final Ordem ordem) {
        return this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
