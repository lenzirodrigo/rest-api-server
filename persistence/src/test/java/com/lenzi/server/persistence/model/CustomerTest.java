package com.lenzi.server.persistence.model;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lenzi.server.persistence.config.HibernateConfig;
import com.lenzi.server.persistence.dao.CustomerDao;

/**
 * @author rlenzi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateConfig.class })
public class CustomerTest {

    @Inject
    private CustomerDao customerDao;

    @Before
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setName("Rodrigo");
        customerDao.addCustomer(customer);
    }

    @Test
    public void getCustomer() {
        Customer customer = customerDao.getCustomerBy(new Long("1"));
        assertEquals("Rodrigo", customer.getName());
    }

}
