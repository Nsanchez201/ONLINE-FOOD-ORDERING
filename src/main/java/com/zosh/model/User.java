package com.zosh.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    Long id; 
    String fullName; 
    String email; 
    String password; 
    String role; 
    List<Order> orders; 
    List<Restaurant> favorites; 
    List<String> addresses; 
    String status;

    public User(){
        this.id = 123456789L; 
        this.fullName = ""; 
        this.email = "";
        this.password = ""; 
        this.role = ""; 
        this.orders = new ArrayList<Order>();
        this.favorites = new ArrayList<Restaurant>(); 
        this.addresses = new ArrayList<String>();
        this.status = "";  
    }

    public User(Long id, String fullName, String email, String password, String role, 
    List<Order> orders, List<Restaurant> favorites, List<String> addresses, String status){
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Restaurant> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Restaurant> favorites) {
        this.favorites = favorites;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
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
    
    