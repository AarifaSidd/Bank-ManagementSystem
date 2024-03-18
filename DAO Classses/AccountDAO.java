package BankingSystem.DAOClasses;

import BankingSystem.Entities.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AccountDAO {

    private final Session session;

    public AccountDAO(Session session) {
        this.session = session;
    }

    public void save(Account account) {
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
    }

    public Account getById(int id) {
        return session.get(Account.class, id);
    }

    public List<Account> getAll() {
        return session.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    public void update(Account account) {
        Transaction transaction = session.beginTransaction();
        session.update(account);
        transaction.commit();
    }

    public void delete(Account account) {
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
    }
}

