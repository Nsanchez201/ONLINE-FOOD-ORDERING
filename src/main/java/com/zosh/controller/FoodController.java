package com.zosh.controller;

import com.zosh.model.Food;
import com.zosh.model.Restaurant;
import com.zosh.model.Users;
import com.zosh.request.CreateFoodRequest;
import com.zosh.service.FoodService;
import com.zosh.service.RestaurantService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/search")
    public ResponseEntity<List<Food>> createFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        List<Food> foods = foodService.searchFood(name);


        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getrestaurantFood(
            @RequestParam boolean vagetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonveg,
            @RequestParam(required = false) String food_category,
            @PathVariable long restaurantId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantsFood(restaurantId,vagetarian,nonveg,seasonal,food_category);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
