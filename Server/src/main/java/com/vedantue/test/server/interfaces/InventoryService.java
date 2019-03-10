package com.vedantue.test.server.interfaces;

import com.vedantue.test.server.representers.InventoryRepresenter;
import org.springframework.http.ResponseEntity;


public interface InventoryService {

    ResponseEntity placeOrder(int accountNumber, InventoryRepresenter.PlaceOrder payload);

    ResponseEntity checkOrderDetails(int accountNumber);
}
