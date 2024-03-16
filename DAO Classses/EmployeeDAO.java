package BankingSystem.DAOClasses;
import BankingSystem.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> getAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}

