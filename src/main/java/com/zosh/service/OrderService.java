package com.zosh.service;

import com.zosh.model.Order;
import com.zosh.model.Users;
import com.zosh.request.OrderRequest;

import java.util.List;

public interface OrderService {
    public Order createOrder (OrderRequest order, Users user) throws Exception;
    public Order updateOrder (Long orderId, String orderStatus) throws Exception;
    public void calcelOrder (Long orderId) throws Exception;
    public List<Order> getUsersOrder (Long userId) throws Exception;
    public List<Order> getRestaurantsorder (Long restaurantId, String orderStatus) throws Exception;
    public Order findOrderById(Long orderId) throws Exception;
}
