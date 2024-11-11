package com.zosh.service;

import com.zosh.model.Cart;
import com.zosh.model.CartItem;
import com.zosh.model.Food;
import com.zosh.model.Users;
import com.zosh.repository.CartItemRepository;
import com.zosh.repository.CartRepository;
import com.zosh.repository.FoodRepository;
import com.zosh.request.addItemCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserService userservice;
    @Autowired
    private FoodService foodservice;

    @Override
    public CartItem addItemToCart(addItemCartRequest req, String jwt) throws Exception {
        Users user = userservice.findUserJwtToken(jwt);
        Food food = foodservice.findFoodById(req.getFoodId());
        Cart cart = cartRepository.findByCustomerId(user.getId());
        for(CartItem cartItem : cart.getItem()){
            if(cartItem.getId().equals(food)){
                int newQuantity = cartItem.getQuantity() + req.getQuantity();
                return updateCartItemQuantity(cartItem.getId(), newQuantity);
            }
        }
        CartItem newCartItem=new CartItem();
        newCartItem.setFood(food);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(req.getQuantity());
        newCartItem.setIngredients(req.getIngredients());
        newCartItem.setTotalPrice(req.getQuantity()*food.getPrice());
        CartItem savedCartItem=cartItemRepository.save(newCartItem);
        cart.getItem().add(savedCartItem);
        return savedCartItem;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);
        if(cartItem.isEmpty()){
            throw new Exception("CartItem not found");
        }
        CartItem item=cartItem.get();
        item.setQuantity(quantity);

        item.setTotalPrice(item.getFood().getPrice()*quantity);
        return cartItemRepository.save(item);
    }


    @Override
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {
        Users user = userservice.findUserJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(user.getId());
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);
        if(cartItem.isEmpty()){
            throw new Exception("CartItem not found");
        }
        CartItem item = cartItem.get();
        cart.getItem().remove(item);

        return cartRepository.save(cart);
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {
        Long total = 0L;
        for(CartItem cartItem : cart.getItem()){
            total += cartItem.getFood().getPrice()*cartItem.getQuantity();
        }
        return total;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {
        Optional<Cart> Optcart = cartRepository.findById(id);
        if(Optcart.isEmpty()){
            throw new Exception("CartItem not found");
        }

        return Optcart.get();
    }

    @Override
    public Cart findCartByUserId(Long userid) throws Exception {
     //   Users user = userservice.findUserJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(userid);
        cart.setTotal(calculateCartTotals(cart));
        return cart;

    }

    @Override
    public Cart clearCart(Long userid) throws Exception {
       // Users user = userservice.findUserJwtToken(jwt);
        Cart cart = findCartByUserId(userid);
        cart.getItem().clear();
        return cartRepository.save(cart);
    }
}
