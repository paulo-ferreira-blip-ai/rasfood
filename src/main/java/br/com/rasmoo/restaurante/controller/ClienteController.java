package br.com.rasmoo.restaurante.controller;

import br.com.rasmoo.restaurante.model.Cliente;
import br.com.rasmoo.restaurante.model.Cliente ;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ClienteController {

    private EntityManager entityManager;

    public ClienteController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente consultarPorId(final Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        try {
            String sql = "SELECT c FROM Cliente c";
            return this.entityManager.createQuery(sql, Cliente.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cliente> consultarPorvalor(final BigDecimal filtro) {

        try {
            String jpql = "SELECT c FROM Cliente c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cliente.class).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cliente consultarPorNome(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public Cliente atualizar(final Cliente cliente) {
        return this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }
}
