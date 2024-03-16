package BankingSystem.DAOClasses;
import BankingSystem.Bank;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import org.hibernate.Session;

import static BankingSystem.Main2.getSessionFactory;


public class BankDAO {

    @PersistenceContext
    private EntityManager entityManager;
    Session session = getSessionFactory().openSession();


    public BankDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Bank bank) {



        entityManager.persist(bank);
    }

//    public Bank getById(int id) {
//        return entityManager.find(Bank.class, id);
//    }
public Bank getById(int id) {
    try {
        return entityManager.find(Bank.class, id);
    } catch (Exception e) {
        System.out.println("Error occurred while fetching bank with ID: " + id);
        e.printStackTrace();
        return null;
    }
}


    public List<Bank> getAll() {
        return entityManager.createQuery("SELECT b FROM Bank b", Bank.class).getResultList();
    }

    @Transactional
    public void update(Bank bank) {
        entityManager.merge(bank);
    }

    @Transactional
    public void delete(Bank bank) {
        entityManager.remove(bank);
    }
    public Bank getBankByDetails(String bankName, String code, String city, String address) {

        Query query = session.createQuery("SELECT b FROM Bank b WHERE b.bankName = :bankName AND b.code = :code AND b.city = :city AND b.address = :address", Bank.class);
        query.setParameter("bankName", bankName);
        query.setParameter("code", code);
        query.setParameter("city", city);
        query.setParameter("address", address);
        return (Bank) query.getResultList().stream().findFirst().orElse(null);
    }
}
