package com.vedantue.test.server.utils;

public class OrderStatus {

    public enum Order {

        Placed(1),
        Cancled(0),
        Delevered(0);

        private final int value;

        Order(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }
}
