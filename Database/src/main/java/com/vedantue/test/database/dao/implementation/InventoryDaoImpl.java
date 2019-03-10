package com.vedantue.test.database.dao.implementation;

import com.vedantue.test.database.dao.interfaces.InventoryDao;
import com.vedantue.test.model.Account;
import com.vedantue.test.model.Inventory;
import com.vedantue.test.model.Orderr;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account getRecord(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    @Override
    public void save(Orderr orderr) {
        sessionFactory.getCurrentSession().save(orderr);
    }

    @Override
    public Inventory getInventory(int iteamsId) {
        return sessionFactory.getCurrentSession().get(Inventory.class, iteamsId);
    }

    @Override
    public List<Orderr> getOrderDetails(int accountNumber) {
        return sessionFactory.getCurrentSession().createQuery("from Orderr where account.accountNumber =:accountNumber", Orderr.class).setParameter("accountNumber", accountNumber).list();
    }
}
