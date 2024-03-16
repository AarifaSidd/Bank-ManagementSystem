package BankingSystem.DAOClasses;
import BankingSystem.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class AccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Account account) {
        entityManager.persist(account);
    }

    public Account getById(int id) {
        return entityManager.find(Account.class, id);
    }

    public List<Account> getAll() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    @Transactional
    public void update(Account account) {
        entityManager.merge(account);
    }

    @Transactional
    public void delete(Account account) {
        entityManager.remove(account);
    }
}
