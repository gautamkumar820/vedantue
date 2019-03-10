package com.vedantue.test.server.controllers;

import com.vedantue.test.server.interfaces.InventoryService;
import com.vedantue.test.server.representers.InventoryRepresenter;
import com.vedantue.test.server.utils.MimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    /*
     * This service is use to place the user's ordes as pe the user requirement
     * they can order one or multiple iteams by selecting from Iteam list.
     * */
    @RequestMapping(value = "/place_order/{accountNumber}", method = RequestMethod.POST, produces = {MimeType.PRODUCE_JSON, MimeType.PRODUCE_XML})
    private ResponseEntity placeOrder(@PathVariable int accountNumber, @RequestBody InventoryRepresenter.PlaceOrder payload) {
        return inventoryService.placeOrder(accountNumber, payload);
    }

    /*
     * This service is use to check the user ordes by user's accountNumber.
     * */
    @RequestMapping(value = "/check_order/{accountNumber}", method = RequestMethod.GET, produces = {MimeType.PRODUCE_JSON, MimeType.PRODUCE_XML})
    private ResponseEntity checkOrderDetails(@PathVariable int accountNumber) {
        return inventoryService.checkOrderDetails(accountNumber);
    }
}
