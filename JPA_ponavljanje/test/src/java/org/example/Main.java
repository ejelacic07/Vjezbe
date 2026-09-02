package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Ingredient;
import org.example.model.Meal;

import java.util.List;


public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("menu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("rice");
        em.persist(ingredient1);


        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("pepper");
        em.persist(ingredient2);


        Meal meal1 = new Meal();
        meal1.setName("Stuffed peppers");
        meal1.getIngredients().add(ingredient1);
        meal1.getIngredients().add(ingredient2);
        em.persist(meal1);


        List<Meal> meals =
                em.createQuery("select m from Meal m",
                        Meal.class).getResultList();

        for (Meal m : meals) {
            System.out.println("Naziv: " + m.getName());

            for (Ingredient i : m.getIngredients()) {
                System.out.println("Ingredient is: " + i.getName());
            }
        }


         Meal meal = em.find(Meal.class, 1L);

        if (meal != null) {
            meal.setName("Kimchi");
            meal = em.find(Meal.class, 1L);
            System.out.println("New meal: " + meal.getName());
        }
        meal = em.find(Meal.class, 1L);



        tx.commit();
        em.close();
        emf.close();

        }
    }
