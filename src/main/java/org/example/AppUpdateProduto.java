package org.example;

import Entity.Carro;
import Entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

import java.util.Locale;

public class AppUpdateProduto {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        EntityManager ent = JpaUtil.getEntityManager();
        EntityTransaction tx = ent.getTransaction();




        Carro carro = new Carro();
        try {

            tx.begin();

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