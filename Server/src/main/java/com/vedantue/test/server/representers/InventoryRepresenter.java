package com.vedantue.test.server.representers;

public class InventoryRepresenter {

    public InventoryRepresenter() {
    }

    public static class PlaceOrder {

        private Integer iteamId;

        private Integer iteamsCount;


        public PlaceOrder() {
        }

        public Integer getIteamId() {
            return iteamId;
        }

        public void setIteamId(Integer iteamId) {
            this.iteamId = iteamId;
        }

        public Integer getIteamsCount() {
            return iteamsCount;
        }

        public void setIteamsCount(Integer iteamsCount) {
            this.iteamsCount = iteamsCount;
        }

        public String validateRequest() {
            if (iteamId == null) {
                return "IteamId Is Required";
            }
            if (iteamsCount == null) {
                return "IteamsCount Is required";
            }
            return null;
        }
    }
}
