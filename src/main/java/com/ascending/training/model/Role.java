package com.ascending.training.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "allowed_resource")
    private String allowedResource;

    @Column(name = "allowed_read")
    private boolean allowedRead;

    @Column(name = "allowed_create")
    private boolean allowedCreate;

    @Column(name = "allowed_update")
    private boolean allowedUpdate;

    @Column(name = "allowed_delete")
    private boolean allowedDelete;

    @ManyToMany(mappedBy = "roles")
    private List<Customer> customers;
}