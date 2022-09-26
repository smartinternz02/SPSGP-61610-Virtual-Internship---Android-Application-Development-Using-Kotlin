package com.example.checkboxandtoast;

import java.io.Serializable;

public class ItemsDetail implements Serializable {
    String ItemName;
    String ItemType;
    boolean active;

    public ItemsDetail(String ItemName,String ItemType){
        this.ItemName=ItemName;
        this.ItemType=ItemType;
        this.active=active;

    }

    public String getItemName(){
        return ItemName;
    }

    public void setItemName()
    {
        this.ItemName=ItemName;
    }
    public String getItemType(){
        return ItemType;
    }

    public void setItemType(String itemType) {
        this.ItemType=ItemType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.ItemName+"("+this.ItemType+")";
    }
}
