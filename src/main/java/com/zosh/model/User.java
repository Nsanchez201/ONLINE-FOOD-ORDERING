package com.zosh.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    @id
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


}
    
    