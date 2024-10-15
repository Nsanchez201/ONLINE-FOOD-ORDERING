package com.zosh.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private  Cart cart;

    @ManyToOne
    private Food food;

    private int quantity;


    private List<String> ingredients;

   private Long totalPrice;

}
