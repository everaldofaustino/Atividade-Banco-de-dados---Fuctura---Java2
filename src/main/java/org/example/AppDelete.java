package org.example;

import Entity.Carro;
import Entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

import java.util.Locale;

public class AppDelete {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        EntityManager ent = JpaUtil.getEntityManager();
        EntityTransaction tx = ent.getTransaction();



        Produto produto = new Produto();
        Carro carro = new Carro();
        try {

            tx.begin();

            // BUSCA O PRODUTO PELO ID
            // find(Produto.class, 4) → SELECT * FROM produto WHERE id = 4
            produto = ent.find(Produto.class,4);

            // REMOVE O PRODUTO
            // ent.remove(produto) → DELETE FROM produto WHERE id = 4
            ent.remove(produto);

            // BUSCA O CARRO PELO ID
            // find(Carro.class, 2) → SELECT * FROM carro WHERE id = 2
            carro = ent.find(Carro.class,2);

            // REMOVE O CARRO
            // DELETE FROM carro WHERE id = 2
            ent.remove(carro);



            tx.commit();
            ent.close();

        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }

        ent.close();
    }
}