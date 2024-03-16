package BankingSystem.DAOClasses;
import BankingSystem.Branch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class BranchDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Branch branch) {
        entityManager.persist(branch);
    }

    public Branch getById(int id) {
        return entityManager.find(Branch.class, id);
    }

    public List<Branch> getAll() {
        return entityManager.createQuery("SELECT b FROM Branch b", Branch.class).getResultList();
    }

    @Transactional
    public void update(Branch branch) {
        entityManager.merge(branch);
    }

    @Transactional
    public void delete(Branch branch) {
        entityManager.remove(branch);
    }
}
