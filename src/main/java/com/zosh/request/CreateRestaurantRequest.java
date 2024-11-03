package com.zosh.request;


import com.zosh.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private long id;
    private String name;
    private String description;
    private String cuisineType;
    private String address;
    private ContactInformation contactInformation;
    private String OpeningHours;
    private List<String> images;

}
