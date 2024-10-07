package com.zosh.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@Data
@Entity
// @NoArgsConstructor
@AllArgsConstructor 
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @OneToOne
    private User owner; 

    private String name; 

    private String description;
    private String cuisineType; 

    @OneToOne
    private Address address; 

    @Embedded
    private ContactInformation contactInformation; 

    private String openingHours; 

    @OneToMany(mappedBy="restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>(); 

    @ElementCollection
    @Column(length = 1000)
    private List<String> images; 

    private LocalDateTime registrationDate; 

    private boolean open; 

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();
    
    //Default Constructor
    public Restaurant() {
        //this("")
    }

    public Restaurant(Long id, User owner, String name, String description, String cuisineType, Address address,
            ContactInformation contactInformation, String openingHours, List<Order> orders, List<String> images,
            LocalDateTime registrationDate, boolean open, List<Food> foods) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.cuisineType = cuisineType;
        this.address = address;
        this.contactInformation = contactInformation;
        this.openingHours = openingHours;
        this.orders = orders;
        this.images = images;
        this.registrationDate = registrationDate;
        this.open = open;
        this.foods = foods;
    }

    

}
