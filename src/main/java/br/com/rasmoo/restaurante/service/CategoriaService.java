package br.com.rasmoo.restaurante.service;

import br.com.rasmoo.restaurante.controller.CardapioController;
import br.com.rasmoo.restaurante.controller.CategoriaController;
import br.com.rasmoo.restaurante.model.Cardapio;
import br.com.rasmoo.restaurante.model.Categoria;
import br.com.rasmoo.restaurante.repository.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CategoriaService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        var categoria = cadastrarCategorai(entityManager);
        cadastrarProdutoCardapio(entityManager, categoria);
    }


    public static Categoria cadastrarCategorai(EntityManager entityManager) {
        CategoriaController categoriaController = new CategoriaController(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");

        entityManager.getTransaction().begin();
        categoriaController.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {


        Cardapio risoto = new Cardapio();
        risoto.setCategoria(categoria);
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        risoto.setCategoria(categoria);
        risoto.setNome("Salmão");
        risoto.setDescricao("Salmão ao molho de maracuja");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(60.50));


        CardapioController cardapioController = new CardapioController(entityManager);

        //Parte CRUD
        entityManager.getTransaction().begin();
        cardapioController.cadastrar(risoto);
        entityManager.flush();
        cardapioController.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O Cardapio consultado foi: " + cardapioController.consultarPorId(1));
        System.out.println("O Cardapio consultado foi: " + cardapioController.consultarPorId(2));

        entityManager.clear();

    }
}
