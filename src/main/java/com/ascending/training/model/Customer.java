package com.ascending.training.model;

import javax.persistence.*;

@Entity
@Table(name="customer")

public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() { return sex; }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    public String toString(){
        return String.format("id= %d", getID());
    }
}


