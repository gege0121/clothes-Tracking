package com.ascending.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "historys")
public class History {
    public History(){
    }
    public History(LocalDate date, Integer temperature){
        this.date=date;
        this.temperature=temperature;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "temperature")
    private Integer temperature;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
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
