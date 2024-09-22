package com.mango.order.entity;

import com.mango.order.dto.FoodItemDTO;
import com.mango.order.dto.RestaurantDTO;
import com.mango.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private RestaurantDTO restaurant;
    private UserDto user;
}
