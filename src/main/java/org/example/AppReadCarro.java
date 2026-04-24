package org.example;

import Entity.Carro;
import Entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

import java.util.List;
import java.util.Locale;

public class AppReadCarro {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        EntityManager ent = JpaUtil.getEntityManager();
        EntityTransaction tx = ent.getTransaction();





        // Carro carro = new Carro();

        try {

            tx.begin();

            // carro = ent.find(Carro.class,2);
            //   System.out.println(carro);


            // .getResultList() - Executa a query e retorna uma List com os resultados
            List<Carro> carros = ent
                    .createQuery("FROM Carro", Carro.class)
                    .getResultList();

            for (int i = 0; i < carros.size(); i++) {
                Carro carro = carros.get(i);
                System.out.println(carro);
            }

            //for (Carro carro : carros) {
            //	System.out.println(carro);
            //	}

            // carros.forEach(carro -> { System.out.println(carro); });


            tx.commit();
            ent.close();

        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }


    }
}