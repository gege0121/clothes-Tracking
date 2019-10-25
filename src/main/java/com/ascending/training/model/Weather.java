package com.ascending.training.model;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(name = "temperature")
    private Integer temperature;
    @Column(name = "season")
    private String season;
    @Column(name = "warmLevel")
    private Integer warmLevel;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getSeason() {
        return season;
    }

    public void setColor(String season) {
        this.season = season;
    }

    public int getWarmLevel() {
        return warmLevel;
    }

    public void setWarmlevel(int warmLevel) {
        this.warmLevel = warmLevel;
    }

    public String toString() {
        return String.format("id= %d", getID());
    }
}
