package com.lenzi.server.persistence.model;

import javax.inject.Inject;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lenzi.server.persistence.config.HibernateConfig;

/**
 * @author rlenzi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateConfig.class })
public class CustomerTest {

    @Inject
    private HibernateTransactionManager transactionManager;

    @Test
    public void addCustomer() {
        Session currentSession = transactionManager.getSessionFactory().openSession();

        Customer customer = new Customer();
        customer.setName("Rodrigo");

        currentSession.save(customer);
        currentSession.flush();
        currentSession.close();
    }

}
