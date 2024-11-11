package com.zosh.request;

import lombok.Data;

import java.util.List;

@Data
public class addItemCartRequest {
    private Long foodId;
    private int quantity;
    private List<String> ingredients;
}
