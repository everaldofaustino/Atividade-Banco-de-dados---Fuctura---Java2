package org.example;

import Entity.Carro;
import Entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppCreateCarro {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        EntityManager ent = JpaUtil.getEntityManager();
        EntityTransaction tx = ent.getTransaction();




        List<Carro> carros = new ArrayList<>();

        Carro c1 = new Carro();
        c1.setModelo("Civic");
        c1.setMarca("Honda");
        c1.setAno(2023);
        c1.setPreco(150000.00);

        Carro c2 = new Carro();
        c2.setModelo("Corolla");
        c2.setMarca("Toyota");
        c2.setAno(2024);
        c2.setPreco(145000.00);

        Carro c3 = new Carro();
        c3.setModelo("Onix");
        c3.setMarca("Chevrolet");
        c3.setAno(2022);
        c3.setPreco(75000.00);

        Carro c4 = new Carro();
        c4.setModelo("Hilux");
        c4.setMarca("Toyota");
        c4.setAno(2023);
        c4.setPreco(280000.00);

        carros.add(c1);
        carros.add(c2);
        carros.add(c3);
        carros.add(c4);


        try {

            tx.begin();



            // Equivalente SQL: INSERT INTO produto (nome, preco, estoque, data) VALUES (...)
            for(Carro carro : carros){
                ent.persist(carro);
            }

            tx.commit();

            ent.close();

        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }

        ent.close();
    }
}