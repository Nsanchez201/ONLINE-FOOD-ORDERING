package com.zosh.controller;


import com.zosh.model.Restaurant;
import com.zosh.model.User;
import com.zosh.request.CreateRestaurantRequest;
import com.zosh.response.MessageResponse;
import com.zosh.service.RestaurantService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/restaurants")
public class AdminRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;


    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(
            @RequestBody CreateRestaurantRequest  req,
            @RequestHeader("Authorization") String jwt
            ) throws Exception {
        User user = userService.findUserJwtToken(jwt);
        Restaurant restaurant = restaurantService.createRestaurant(req, user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurantRequest  req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long Id
    ) throws Exception {
        User user = userService.findUserJwtToken(jwt);
        Restaurant restaurant = restaurantService.updateRestaurant(Id, req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(
            @RequestBody CreateRestaurantRequest  req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long Id
    ) throws Exception {
        User user = userService.findUserJwtToken(jwt);
        restaurantService.deleteRestaurant(Id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Restaurant deleted");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
