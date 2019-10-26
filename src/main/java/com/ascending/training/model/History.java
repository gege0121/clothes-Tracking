package com.ascending.training.model;

import java.util.Date;

public class History {
    public History(){
    }
    public History(Date date, Integer temperature){
        this.date=date;
        this.temperature=temperature;
    }
    private Date date;
    private Integer temperature;
    private int id;

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date=date;
    }

    public Integer getTemperature(){
        return temperature;
    }
    public void setTemperature(Integer temperature){
        this.temperature=temperature;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
