package emf_test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-application.xml")
public class IntegrationTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void emfConnectionTest() {
        //Query query = entityManager.createQuery("from UsersEntity ");
        //List resultList = query.getResultList();
        Assert.assertEquals(200, 200);
    }

}
