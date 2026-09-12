package hr.java.jpa.demo;

import hr.java.jpa.demo.model.Author;
import hr.java.jpa.demo.model.Book;
import hr.java.jpa.demo.model.Publisher;
import hr.java.jpa.demo.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        createAndSaveData();
        selectAuthorsAndBooks();
        updateBookTitle(1L, "Stoner");
        deleteBook(2L);

    }

    public static void createAndSaveData() {

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            transaction.begin();

            Publisher publisher1 = new Publisher("Fraktura");
            Publisher publisher2 = new Publisher("Prentice Hall");

            Set<Publisher> publishers = new HashSet<>();
            publishers.add(publisher1);
            publishers.add(publisher2);


            Book book1 = new Book("Stoner");
            Book book2 = new Book("Clean code");

            Set<Book> books1 = new HashSet<>();
            Set<Book> books2 = new HashSet<>();
            books1.add(book1);
            books2.add(book2);

            Author author1 = new Author("John Williams");
            Author author2 = new Author("Robert Martin");

            author1.setBooks(books1);
            em.persist(author1);

            author2.setBooks(books2);
            em.persist(author2);

            book1.setAuthor(author1);
            book1.setPublishers(publishers);
            em.persist(book1);

            book2.setAuthor(author2);
            book2.setPublishers(publishers);
            em.persist(book2);

            publisher1.setBooks(books1);
            em.persist(publisher1);

            publisher2.setBooks(books2);
            em.persist(publisher2);

            transaction.commit();
            System.out.println("Transaction commited");



        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
                System.err.println("Transaction rolled back");
            }
            e.printStackTrace();

        } finally {
            em.close();
        }

    }


    public static void selectAuthorsAndBooks() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query upit = em.createQuery("From Author", Author.class);
            List<Author> authors = upit.getResultList();

            authors.forEach(author -> {
                System.out.println("Autor je: " + author.getName());
                author.getBooks().forEach(book -> {
                    System.out.println("\nNaziv autora " + author.getName() + ". ID: " + author.getId() +
                            ". Knjiga: " + book.getTitle() +
                            ". Broj izdavača: " + book.getPublishers().size() + "\n");

                });
            });

        } finally {
            em.close();
        }
    }


    public static void updateBookTitle(Long id, String newTitle) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Book book = em.find(Book.class, id);
            if (book != null) {
                book.setTitle(newTitle);
                em.merge(book);
            }
            transaction.commit();

            assert book != null;
            System.out.println("Book ID: " + book.getId() + ". New title " + book.getTitle() + ".");

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public static void deleteBook(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Book book = em.find(Book.class, id);
            if (book != null) {
                em.remove(book);
            }
            transaction.commit();

            assert book != null;
            System.out.println("ID obrisane knjige: " + id);

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


}