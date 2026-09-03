package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Company;
import org.example.model.Contract;
import org.example.model.Person;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contracts");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Company company1 = new Company();
        company1.setName("Span");
        entityManager.persist(company1);

        Person person1 = new Person();
        person1.setName("Nikola Dujmović");
        entityManager.persist(person1);


        Company company2 = new Company();
        company2.setName("Infobip");
        entityManager.persist(company2);

        Person person2 = new Person();
        person2.setName("Silvio Kutić");
        entityManager.persist(person2);


        String datum = "2025-10-18";
        LocalDate konvertiraniDatum = LocalDate.parse(datum);

        Contract contract1 = new Contract();
        contract1.setStartDate(konvertiraniDatum);
        contract1.getCompanies().add(company1);
        contract1.getEmployees().add(person1);
        entityManager.persist(contract1);


        Contract contract2 = new Contract();
        contract2.setStartDate(konvertiraniDatum);
        contract2.getCompanies().add(company1);
        contract2.getCompanies().add(company2);
        contract2.getEmployees().add(person1);
        contract2.getEmployees().add(person2);
        entityManager.persist(contract2);

        entityTransaction.commit();

        entityManager.close();
        emf.close();

    }
}