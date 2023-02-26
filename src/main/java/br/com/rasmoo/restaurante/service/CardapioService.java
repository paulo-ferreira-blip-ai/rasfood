package br.com.rasmoo.restaurante.service;

import br.com.rasmoo.restaurante.controller.CardapioController;
import br.com.rasmoo.restaurante.model.Cardapio;
import br.com.rasmoo.restaurante.repository.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmão = new Cardapio();
        risoto.setNome("Salmão");
        risoto.setDescricao("Salmão ao molho de maracuja");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(60.50));


        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        CardapioController cardapioController =new CardapioController(entityManager);
        entityManager.getTransaction().begin();


        cardapioController.cadastrar(risoto);
        entityManager.flush();
        cardapioController.cadastrar(salmão);
        entityManager.flush();

        System.out.printf("Lista de produtos por nome: " + cardapioController.consultarPorNome("salmão"));
//        cardapioController.consultarTodos().forEach(elemento-> System.out.println("O prato consultado foi: " + elemento));

        entityManager.close();

    }
}
