package com.ascending.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

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

    @JsonView(Customer.CustomerClothesView.class)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonView(Customer.CustomerClothesView.class)
    @Column(name = "type")
    private String type;

    @JsonView(Customer.CustomerClothesView.class)
    @Column(name = "color")
    private String color;

    @JsonView(Customer.CustomerClothesView.class)
    @Column(name = "size")
    private String size;

    @JsonView(Customer.CustomerClothesView.class)
    @Column(name = "tag")
    private String tag;

    @JsonView(Customer.CustomerClothesView.class)
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

    public List<History> getHistory() { return history; }


    public void setHistory(List<History> history) {
        this.history = history;
    }
}
