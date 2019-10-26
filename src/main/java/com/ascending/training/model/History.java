package com.ascending.training.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "history")
public class History {
    public History(){
    }
    public History(Date date, Integer temperature){
        this.date=date;
        this.temperature=temperature;
    }
    @Id
    //@SequenceGenerator(name = "department_id_generator", sequenceName = "department_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = SEQUENCE, generator = "department_id_generator")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;
    @Column(name = "temperature")
    private Integer temperature;



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

//    public void setId(int id) {
//        this.id = id;
//    }


}
