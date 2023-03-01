package br.com.rasmoo.restaurante.controller;

import br.com.rasmoo.restaurante.model.Categoria;
import br.com.rasmoo.restaurante.model.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CategoriaController {
    private EntityManager entityManager;

    public CategoriaController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultarPorId(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos() {
        try {
            String sql = "SELECT c FROM Categoria c";
            return this.entityManager.createQuery(sql, Categoria.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Categoria> consultarPorvalor(final BigDecimal filtro) {

        try {
            String jpql = "SELECT c FROM Categoria c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Categoria.class).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Categoria consultarPorNome(final String filtro) {
        try {
            String jpql = "SELECT c FROM Categoria c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Categoria.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public Categoria atualizar(final Categoria categoria) {
        return this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
