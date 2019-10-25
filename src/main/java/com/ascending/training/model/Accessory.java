package com.ascending.training.model;

import javax.persistence.*;

@Entity
@Table(name="accessory")
public class Accessory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long ID;
    @Column(name = "clothesType")
    private String clothesType;
    @Column(name = "color")
    private String color;
    @Column(name = "warmLevel")
    private int warmLevel;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getWarmLevel() {
        return warmLevel;
    }

    public void setWarmlevel(int warmLevel) {
        this.warmLevel = warmLevel;
    }

    public String toString(){
        return String.format("id= %d", getID());
    }
}