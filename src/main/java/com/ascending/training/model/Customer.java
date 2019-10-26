package com.ascending.training.model;

public class Customer {

    public Customer(){
    }

    public Customer(String nameç, Integer age, String sex, Integer height, Integer weight, Integer primer){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.height=height;
        this.weight=weight;
        this.primer=primer;
    }

    private String name;
    private Integer age;
    private String sex;
    private Integer height;
    private Integer weight;
    private Integer primer;
    private int id;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age=age;
    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }

    public Integer getHeight(){
        return height;
    }
    public void setHeight(Integer height){
        this.height=height;
    }

    public Integer getWeight(){
        return weight;
    }
    public void setWeight(Integer weight){
        this.weight=weight;
    }

    public Integer getPrimer(){
        return primer;
    }
    public void setPrimer(Integer primer){
        this.primer=primer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
