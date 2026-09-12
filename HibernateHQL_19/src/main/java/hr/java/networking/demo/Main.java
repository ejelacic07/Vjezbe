package hr.java.networking.demo;

import hr.java.networking.demo.model.Author;
import hr.java.networking.demo.model.Book;
import hr.java.networking.demo.model.Publisher;
import hr.java.networking.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



public class Main {

    public static void main(String[] args) {

        createAndSaveEntities();
        selectAuthors();
        updateBookTitle(1L, "Clean code");
        deleteBookById(2L);

        HibernateUtil.shutdown();
    }


    public static void createAndSaveEntities() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Author author1 = new Author("John Williams");
            Author author2 = new Author("Robert Martin");

            Book book1 = new Book("Stoner");
            Book book2 = new Book("Clean code");

            Publisher publisher1 = new Publisher("Fraktura");
            Publisher publisher2 = new Publisher("Prentice Hall");

            author1.addBook(book1);
            author2.addBook(book2);

            publisher1.addBook(book1);
            publisher1.addBook(book2);
            publisher2.addBook(book2);


            session.persist(book1);
            session.persist(book2);

            session.persist(author1);
            session.persist(author2);

            session.persist(publisher1);
            session.persist(publisher2);

            transaction.commit();
        }


    }


    public static void selectAuthors() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Author> authors = session.createQuery("from Author", Author.class).list();
            System.out.printf("\u001B[34m" + "Autori: %s" + "\u001B[0m", "");

            authors.forEach(author -> {
                        System.out.printf("\u001B[34m" + "\nAutor je %s" + "\u001B[0m" +  "%n", author.getName() + ".");
                        author.getBooks().forEach(book -> {
                          System.out.printf("\u001B[34m" + "\nKnjiga je %s" + "\u001B[0m" +  "%n", book.getTitle() + ".");
                        });
                    }
            );
        }
    }

    public static void updateBookTitle(Long id, String newTitle) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("UPDATE Book SET title = :newTitle WHERE id = :id")
                    .setParameter("newTitle", newTitle)
                    .setParameter("id", id).executeUpdate();
            transaction.commit();
            System.out.printf("\u001B[32m" + "\nUPDATE transakcija uspješno provedena.  %s"
                    + "\u001B[0m" +  "%n", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBookById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "DELETE FROM Book WHERE id = :id";
            session.createQuery(hql)
                    .setParameter("id", id).executeUpdate();
            transaction.commit();
            System.out.printf("\u001B[32m" + "\nDELETE transakcija uspješno provedena.  %s"
                    + "\u001B[0m" +  "%n", "");
        }
    }


}