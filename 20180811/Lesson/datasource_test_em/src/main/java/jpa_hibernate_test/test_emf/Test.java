package jpa_hibernate_test.test_emf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        Query userQuery = entityManager.createQuery("from UsersEntity ");//JPQL -> HQL
        List resultList = userQuery.getResultList();
        System.out.println(resultList);
        factory.close();
    }
}
