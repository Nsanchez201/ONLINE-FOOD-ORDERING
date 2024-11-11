package com.zosh.controller;


import com.zosh.model.Restaurant;
import com.zosh.model.Users;
import com.zosh.request.CreateRestaurantRequest;
import com.zosh.response.MessageResponse;
import com.zosh.service.RestaurantService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Users users = userService.findUserJwtToken(jwt);
        Restaurant restaurant = restaurantService.createRestaurant(req, users);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurantRequest  req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long Id
    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        Restaurant restaurant = restaurantService.updateRestaurant(Id, req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long Id
    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        restaurantService.deleteRestaurant(Id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Restaurant deleted");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{Id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long Id
    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        Restaurant restaurant= restaurantService.updateRestaurantStatus(Id);


        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(

            @RequestHeader("Authorization") String jwt

    ) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        Restaurant restaurant= restaurantService.getRestaurantByUserId(users.getId());


        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
