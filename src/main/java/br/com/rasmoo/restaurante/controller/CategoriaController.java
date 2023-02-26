package br.com.rasmoo.restaurante.controller;

import br.com.rasmoo.restaurante.model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaController {
    private EntityManager entityManager;

    public CategoriaController(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id){
        return this.entityManager.find(Categoria.class,id);
    }

    public Categoria atualizar(final Categoria categoria){
        return this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
