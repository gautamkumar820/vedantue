package com.vedantue.test.server.dtos;

import com.vedantue.test.model.Orderr;

import java.util.Date;
import java.util.List;

public class InventoryDto {

    public static class OrdersList {

        private long total;
        private List<OrdersDto> list;

        public OrdersList(long total, List<OrdersDto> list) {
            this.total = total;
            this.list = list;
        }
    }

    public static class OrdersDto {
        private Integer accountNumber;
        private Long userId;
        private String firstName;
        private String lastName;
        private String address;
        private Integer iteamId;
        private String iteamName;
        private String description;
        private Integer totalAvailableIteams;
        private Integer price;
        private Integer orderId;
        private Integer itemCount;
        private Date orderPlacedDate;
        private Date updatedDate;

        public OrdersDto(Orderr orderr) {
            accountNumber = orderr.getAccount().getAccountNumber();
            userId = orderr.getAccount().getUserId();
            firstName = orderr.getAccount().getFirstName();
            lastName = orderr.getAccount().getLastName();
            address = orderr.getAccount().getAddress();
            iteamId = orderr.getInventory().getIteamId();
            iteamName = orderr.getInventory().getIteamName();
            description = orderr.getInventory().getDescription();
            totalAvailableIteams = orderr.getInventory().getTotalAvailableIteams();
            price = orderr.getInventory().getPrice();
            orderId = orderr.getOrderId();
            itemCount = orderr.getItemCount();
            orderPlacedDate = orderr.getOrderPlacedDate();
            updatedDate = orderr.getUpdatedDate();
        }
    }

}
