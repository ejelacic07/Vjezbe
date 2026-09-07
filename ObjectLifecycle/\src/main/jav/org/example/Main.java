package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.User;


public class Main {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("user");

        User user1 = new User();
        user1.setUsername("user276");

        User user2 = new User();
        user2.setUsername("korime111");


        persistUser(user1);
        detachUser(user1);


        user1.setUsername("promijenjeno223");

        reattachUser(user1);
        System.out.println("Prvi korisnik: " + user1.getUsername());


        deleteUser(user1.getId());

        emf.close();
    }


    private static void persistUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
            System.out.println("User persisted successfully!");
        } catch (Exception e) {


            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Transaction rolled back!");
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    private static void detachUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.find(User.class, user.getId());
            em.detach(user);
            System.out.println("User detached successfully!");
        } catch (Exception e) {
            System.err.println("Failed to detach User!");
        } finally {
            em.close();
        }
    }


    private static User reattachUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        User mergedUser = null;
        try {
            transaction.begin();
            mergedUser = em.merge(user);
            transaction.commit();
            System.out.println("User reattached (merged) successfully!");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Transaction rolled back!");
            e.printStackTrace();
        } finally {
            em.close();
        }
        return mergedUser;
    }


    private static void deleteUser(Long userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
            }
            transaction.commit();
            System.out.println("User deleted successfully!");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Transaction rolled back!");
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}