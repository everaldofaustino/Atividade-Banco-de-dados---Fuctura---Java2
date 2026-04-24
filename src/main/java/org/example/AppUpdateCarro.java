package org.example;

import Entity.Carro;
import Entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

import java.util.Locale;

public class AppUpdateCarro {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        EntityManager ent = JpaUtil.getEntityManager();
        EntityTransaction tx = ent.getTransaction();



        Produto produto = new Produto();
        Carro carro = new Carro();
        try {

            tx.begin();

            produto = ent.find(Produto.class,3);
            produto.setEstoque(100);
            System.out.println(produto);

            carro = ent.find(Carro.class,2);
            carro.setPreco(150000);
            System.out.println(carro);


            tx.commit();
            ent.close();

        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }

        ent.close();
    }
}