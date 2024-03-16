package BankingSystem.DAOClasses;

import BankingSystem.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getById(int id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> getAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Transactional
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Transactional
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }
}

