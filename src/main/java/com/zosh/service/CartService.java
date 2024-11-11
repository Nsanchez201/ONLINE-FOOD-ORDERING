package com.zosh.service;

import com.zosh.model.Cart;
import com.zosh.model.CartItem;
import com.zosh.request.addItemCartRequest;

public interface CartService {
    public CartItem addItemToCart(addItemCartRequest req, String jwt) throws Exception;

    public CartItem updateCartItemQuantity (Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart (Long cartItemId, String jwt) throws Exception;

    public Long calculateCartTotals (Cart cart) throws Exception;

    public Cart findCartById(Long id) throws Exception;

    public Cart findCartByUserId (Long UserId) throws Exception;
    public Cart clearCart(Long UserId) throws Exception;

}
