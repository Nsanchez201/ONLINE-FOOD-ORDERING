package com.zosh.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @id
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
    public Restaurant () {
        this.owner = "";
        this.name = "";
        this.description = "";
        this.cuisineType = "";
        this.address = "";
        this.contactInformation = "";
        this.openingHours = "";
        this.reviews = new ArrayList<String>();
        this.orders = new ArrayList<Order>();
        this.numRating = 0;
        this.images = "";
        this.registrationDate = new Date();
        this.open = false;
        this.foods = new ArrayList<Food>();
        //this("")
    }


}
