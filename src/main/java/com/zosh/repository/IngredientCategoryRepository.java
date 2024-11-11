package com.zosh.repository;

import com.zosh.model.IngredientCategory;
import com.zosh.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Long> {

    // Option 1: Query by the Restaurant entity itself
    List<IngredientCategory> findByRestaurant(Restaurant restaurant);

    // Option 2: Query by the Restaurant's ID
    List<IngredientCategory> findByRestaurant_Id(Long id);
}
