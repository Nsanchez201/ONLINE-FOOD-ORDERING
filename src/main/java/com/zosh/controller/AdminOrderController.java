package com.zosh.controller;

import com.zosh.model.Order;
import com.zosh.model.Users;
import com.zosh.request.OrderRequest;
import com.zosh.service.OrderService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    @GetMapping("/order/restaurant/{id}")
    public ResponseEntity<List<Order>> GetOrderHistory(
            @PathVariable Long id,
            @RequestParam(required = false) String status,
            @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findUserJwtToken(jwt);
        List<Order> order = orderService.getRestaurantsorder(id,status);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @PutMapping("/order/{id}/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long id,
            @PathVariable String orderStatus,
            @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findUserJwtToken(jwt);
       Order order = orderService.updateOrder(id,orderStatus);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }
}
