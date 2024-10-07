package com.zosh.model;

import com.zosh.dto.RestaurantDto;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id; 

    private String fullName; 

    private String email; 

    private String password; 

    private USER_ROLE role; 

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>(); 

    @ElementCollection
    private List<RestaurantDto> favorites = new ArrayList<>(); 

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>(); 

    private String status;

    //Default Constructor   
    public User(){
        this(123456789L, "", "", "", USER_ROLE.ROLE_CUSTOMER, new ArrayList<Order>(), 
        new ArrayList<RestaurantDto>(), new ArrayList<Address>(), "");
    }

    public User(Long id, String fullName, String email, String password, USER_ROLE role, List<Order> orders,
            List<RestaurantDto> favorites, List<Address> addresses, String status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.orders = orders;
        this.favorites = favorites;
        this.addresses = addresses;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<RestaurantDto> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<RestaurantDto> favorites) {
        this.favorites = favorites;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", role="
                + role + ", orders=" + orders + ", favorites=" + favorites + ", addresses=" + addresses + ", status="
                + status + "]";
    }

}
    
    