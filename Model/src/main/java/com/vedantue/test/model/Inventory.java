package com.vedantue.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INVENTORY")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iteamId")
    private Integer iteamId;

    @Column(name = "iteamName")
    private String iteamName;

    @Column(name = "description")
    private String description;

    @Column(name = "totalAvailableIteams")
    private Integer totalAvailableIteams;

    @Column(name = "price")
    private Integer price;

    public Inventory() {
    }

    public Integer getIteamId() {
        return iteamId;
    }

    public void setIteamId(Integer iteamId) {
        this.iteamId = iteamId;
    }

    public String getIteamName() {
        return iteamName;
    }

    public void setIteamName(String iteamName) {
        this.iteamName = iteamName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalAvailableIteams() {
        return totalAvailableIteams;
    }

    public void setTotalAvailableIteams(Integer totalAvailableIteams) {
        this.totalAvailableIteams = totalAvailableIteams;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
