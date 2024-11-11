package com.zosh.controller;


import com.zosh.dto.RestaurantDto;
import com.zosh.model.Restaurant;
import com.zosh.model.Users;
import com.zosh.service.RestaurantService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;


    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(

            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(

            @RequestHeader("Authorization") String jwt

    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        List<Restaurant> restaurant = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id

    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id

    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        RestaurantDto restaurant = restaurantService.addToFavorites(id, users);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
