package com.zosh.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant {

    int id; 
    String owner; 
    String name; 
    String description;
    String cuisineType; 
    String address; 
    String contactInformation; 
    String openingHours; 
    List<String> reviews;
    List<Order> orders; 
    int numRating; 
    String images; 
    Date registrationDate; 
    Boolean open; 
    List<Food> foods; 
    
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
    }

    public Restaurant(int id, String owner, String name, String description, String cuisineType, String address,
            String contactInformation, String openingHours, List<String> reviews, List<Order> orders, int numRating,
            String images, Date registrationDate, Boolean open, List<Food> foods) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.cuisineType = cuisineType;
        this.address = address;
        this.contactInformation = contactInformation;
        this.openingHours = openingHours;
        this.reviews = reviews;
        this.orders = orders;
        this.numRating = numRating;
        this.images = images;
        this.registrationDate = registrationDate;
        this.open = open;
        this.foods = foods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getNumRating() {
        return numRating;
    }

    public void setNumRating(int numRating) {
        this.numRating = numRating;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", owner=" + owner + ", name=" + name + ", description=" + description
                + ", cuisineType=" + cuisineType + ", address=" + address + ", contactInformation=" + contactInformation
                + ", openingHours=" + openingHours + ", reviews=" + reviews + ", orders=" + orders + ", numRating="
                + numRating + ", images=" + images + ", registrationDate=" + registrationDate + ", open=" + open
                + ", foods=" + foods + "]";
    }

}
