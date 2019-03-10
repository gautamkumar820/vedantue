package com.vedantue.test.database.dao.interfaces;

import com.vedantue.test.model.Account;
import com.vedantue.test.model.Inventory;
import com.vedantue.test.model.Orderr;

import java.util.List;

public interface InventoryDao {

    Account getRecord(int ID);

    void save(Orderr orderr);

    Inventory getInventory(int iteamsId);

    List<Orderr> getOrderDetails(int accountNumber);
}
