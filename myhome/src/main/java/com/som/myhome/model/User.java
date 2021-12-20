package com.som.myhome.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(
      name = "user_role", 
      joinColumns = @javax.persistence.JoinColumn(name = "user_id"), 
      inverseJoinColumns = @javax.persistence.JoinColumn(name = "role_id"))

    private List<Role> roles = new ArrayList<>();
}
