package com.lenzi.server.persistence.dao;


import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lenzi.server.persistence.model.Customer;

/**
 * @author flenzi
 */
@Repository
@Transactional
public class CustomerDao {

    @Inject
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Inject
    public DataSource dataSource;

    public String sayHola() {
        return "hola";
    }

    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(Customer.class.toString(), customer);
    }

    public Customer getCustomerBy(Long id) {

        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }
}
