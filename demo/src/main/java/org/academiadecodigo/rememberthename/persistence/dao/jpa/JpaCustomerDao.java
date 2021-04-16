package org.academiadecodigo.rememberthename.persistence.dao.jpa;

import org.academiadecodigo.rememberthename.persistence.dao.CustomerDao;
import org.academiadecodigo.rememberthename.persistence.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    public JpaCustomerDao() {
        super(Customer.class);
    }
}
