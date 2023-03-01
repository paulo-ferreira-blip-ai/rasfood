package br.com.rasmoo.restaurante.service;

import br.com.rasmoo.restaurante.controller.OrdemController;
import br.com.rasmoo.restaurante.repository.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        OrdemController ordemController = new OrdemController(entityManager);
        entityManager.getTransaction().begin();
    }
}
