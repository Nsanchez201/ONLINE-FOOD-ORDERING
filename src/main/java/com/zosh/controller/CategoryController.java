package com.zosh.controller;

import com.zosh.model.Category;
import com.zosh.model.Users;
import com.zosh.service.CategoryService;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                   @RequestHeader("Authorization") String jwt) throws Exception {

        Users user = userService.findUserJwtToken(jwt);
        Category createdcategory = categoryService.createCategory(category.getName(), user.getId());
        return new ResponseEntity<>(createdcategory, HttpStatus.CREATED);
    }

    @GetMapping("/category/restaurant")
    public ResponseEntity <List<Category>> getResraurantCategory(
                                                   @RequestHeader("Authorization") String jwt) throws Exception {

        Users user = userService.findUserJwtToken(jwt);
        List<Category> categories = categoryService.findCategoryByRestaurantId(user.getId());
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }



}
