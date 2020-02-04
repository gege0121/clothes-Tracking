package com.ascending.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clothess")
public class Clothes {

    public Clothes() {
    }

    public Clothes(String type, String color, String size, String tag) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.tag = tag;

    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "tag")
    private String tag;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "clothes", cascade =CascadeType.REMOVE, fetch=FetchType.LAZY)
    private List<History> history;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<History> getHistory() {
        try{
            int size = history.size();//try catch the exception if the clothes are not fetched
        }
        catch(Exception e) {
            return null;
        }
        return history;
    }


    public void setHistory(List<History> history) {
        this.history = history;
    }
}
