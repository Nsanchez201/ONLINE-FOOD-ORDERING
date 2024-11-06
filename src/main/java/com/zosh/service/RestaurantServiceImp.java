package com.zosh.service;

import com.zosh.dto.RestaurantDto;
import com.zosh.model.Address;
import com.zosh.model.Restaurant;
import com.zosh.model.User;
import com.zosh.repository.AddressRepository;
import com.zosh.repository.RestaurantRepository;
import com.zosh.repository.UserRepository;
import com.zosh.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
        Address address = addressRepository.save(req.getAddress());

        Restaurant restaurant = new Restaurant();

        restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);

        if(restaurant.getCuisineType() != null){
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }

        if(restaurant.getDescription() != null){
            restaurant.setDescription(updateRestaurant.getDescription());
        }
        if(restaurant.getName() != null){
            restaurant.setName(updateRestaurant.getName());
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);

    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String key) {
        return restaurantRepository.findBySearchQuery(key);
    }

    @Override
    public Restaurant findRestaurantById(Long Id) throws Exception {
        Optional<Restaurant> opt = restaurantRepository.findById(Id);

        if(opt.isEmpty()){
            throw new Exception("Restaurant not found with id: " + Id);
        }
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long UserId) throws Exception {
        Restaurant restaurant = restaurantRepository.findByOwnerId(UserId);
        if(restaurant == null){
            throw new Exception("Restaurant not found with owner id: " + UserId);
        }
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {
       Restaurant restaurant = findRestaurantById(restaurantId);

       RestaurantDto dto = new RestaurantDto();

       dto.setDescription(restaurant.getDescription());
       dto.setImages(restaurant.getImages());
       dto.setTitle(restaurant.getName());
       dto.setId(restaurantId);

       boolean isFavorited = false;
       List<RestaurantDto> favorites = user.getFavorites();
       for(RestaurantDto favorite : favorites){
           if(favorite.getId().equals(restaurantId)){
               isFavorited = true;
               break;
           }
       }

       if(isFavorited){
           favorites.removeIf(favorite -> favorite.getId().equals(restaurantId));
       } else{
           favorites.add(dto);
       }


        userRepository.save(user);
       return dto;

    }

    @Override
    public Restaurant updateRestaurantStatus(Long Id) throws Exception {
       Restaurant restaurant = findRestaurantById(Id);
       restaurant.setOpen(!restaurant.isOpen());

        return restaurantRepository.save(restaurant);
    }
}
