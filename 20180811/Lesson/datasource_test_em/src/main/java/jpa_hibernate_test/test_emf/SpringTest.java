package jpa_hibernate_test.test_emf;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SpringTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-application.xml");
        EntityManagerFactory entityManagerFactory = applicationContext.getBean("entityManagerFactory",
                EntityManagerFactory.class);


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List resultList = entityManager.createQuery("select u from UsersEntity u").
                getResultList();


        System.out.println(resultList);

    }
}
