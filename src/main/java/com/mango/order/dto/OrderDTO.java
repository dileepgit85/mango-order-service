package com.mango.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer userId;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
}
