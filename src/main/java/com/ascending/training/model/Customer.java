package com.ascending.training.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    public Customer(){
    }

    public Customer(String name, Integer age, Integer gender, Integer height, Integer weight, Integer primer, String password, String email){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.height=height;
        this.weight=weight;
        this.primer=primer;
        this.password=password;
        this.email=email;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", primer=" + primer +
                ", password='" + password + '\'' +
                '}';
    }

    @Column(name="email")
    private String email;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "primer")
    private Integer primer;

    @Column(name="password")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "customer", cascade =CascadeType.REMOVE, fetch=FetchType.LAZY)
    private List<Clothes> clothes;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "customers_roles",joinColumns = { @JoinColumn(name = "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id")})
    private List<Role> roles;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age=age;
    }

    public Integer getGender(){
        return gender;
    }
    public void setGender(Integer gender){
        this.gender=gender;
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

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password= DigestUtils.md5Hex(password.trim()); }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
