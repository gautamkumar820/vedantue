package com.vedantue.test.server.services;

import com.google.gson.Gson;
import com.vedantue.test.database.dao.interfaces.InventoryDao;
import com.vedantue.test.model.Account;
import com.vedantue.test.model.Inventory;
import com.vedantue.test.model.Orderr;
import com.vedantue.test.server.dtos.InventoryDto;
import com.vedantue.test.server.interfaces.InventoryService;
import com.vedantue.test.server.representers.InventoryRepresenter;
import com.vedantue.test.server.utils.JsonResponse;
import com.vedantue.test.server.utils.OrderStatus;
import com.vedantue.test.server.utils.VedantueConstants;
import com.vedantue.test.server.utils.exceptions.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDao inventoryDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * This service is use to place the user's ordes as pe the user requirement
     * they can order one or multiple iteams by selecting from Iteam list.
     * */
    @Override
    public ResponseEntity placeOrder(int accountNumber, InventoryRepresenter.PlaceOrder payload) {
        return ExceptionHandler.handle(
                () -> {
                    // validateRequest method is responsible to all the input data as per the input requirement
                    String validateRequest = payload.validateRequest();
                    if (validateRequest == null) {
                        //Fetch the Account Details by accountNumber
                        Account account = inventoryDao.getRecord(accountNumber);
                        if (account != null) {
                            //Fetch the Inventory Details by IteamId
                            Inventory inventory = inventoryDao.getInventory(payload.getIteamId());
                            if (inventory != null) {
                                // Few of the Business logic as per the Business Operations
                                if (payload.getIteamsCount() < inventory.getTotalAvailableIteams()) {
                                    int totalPrices = inventory.getPrice() * payload.getIteamsCount();
                                    if (totalPrices < account.getAvailableBalance()) {

                                        inventory.setTotalAvailableIteams(inventory.getTotalAvailableIteams() - payload.getIteamsCount());
                                        account.setAvailableBalance(account.getAvailableBalance() - totalPrices);
                                        Orderr orderr = new Orderr(payload.getIteamsCount(), OrderStatus.Order.Placed.getValue(), account, inventory);
                                        //To save the order details and update the availableBalance of user
                                        // and Inventory Details as per the ordered Iteams
                                        inventoryDao.save(orderr);
                                        return new ResponseEntity(JsonResponse.constructResponse(VedantueConstants.SAVED_SUCCESSFULLY), HttpStatus.OK);

                                    }
                                    return new ResponseEntity(JsonResponse.constructResponse(VedantueConstants.YOU_HAVE_INSUFFICIENT_BALANCE), HttpStatus.NOT_FOUND);
                                }
                                return new ResponseEntity(JsonResponse.constructResponse(VedantueConstants.STOCK_NOT_FOUND), HttpStatus.NOT_FOUND);
                            }
                            return new ResponseEntity(JsonResponse.constructResponse(VedantueConstants.INVENTORY_DETAILS_NOT_FOUND), HttpStatus.NOT_FOUND);
                        }
                        return new ResponseEntity(JsonResponse.constructResponse(VedantueConstants.ACCOUNT_DETAILS_NOT_FOUND), HttpStatus.NOT_FOUND);
                    }
                    return new ResponseEntity(JsonResponse.constructResponse(validateRequest), HttpStatus.BAD_REQUEST);
                },
                VedantueConstants.DEFAULT_SERVER_ERROR_MESSAGE
        );
    }

    /*
     * This service is use to check the user ordes by user's accountNumber.
     * */
    @Override
    public ResponseEntity checkOrderDetails(int accountNumber) {
        return ExceptionHandler.handle(
                () -> {
                    // To get the user's orders list by user's accountNumber
                    List<Orderr> orderrs = inventoryDao.getOrderDetails(accountNumber);
                    if (orderrs != null && orderrs.size() > 0) {
                        //
                        List<InventoryDto.OrdersDto> ordersDtos = new ArrayList<>();
                        for (Orderr orderr : orderrs) {
                            ordersDtos.add(new InventoryDto.OrdersDto(orderr));
                        }
                        InventoryDto.OrdersList ordersList = new InventoryDto.OrdersList(orderrs.size(), ordersDtos);
                        return new ResponseEntity(new Gson().toJson(ordersList), HttpStatus.OK);
                    }
                    return new ResponseEntity(JsonResponse.constructResponse(VedantueConstants.ORDER_DETAILS_NOT_FOUND), HttpStatus.NOT_FOUND);
                },
                VedantueConstants.DEFAULT_SERVER_ERROR_MESSAGE
        );
    }
}
