package com.mango.order.service;

import com.mango.order.dto.OrderDTO;
import com.mango.order.dto.OrderDtoFromFE;
import com.mango.order.dto.UserDto;
import com.mango.order.entity.Order;
import com.mango.order.mapper.OrderMapper;
import com.mango.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private SequencyGenerator sequencyGenerator;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO createOrderInDb(OrderDtoFromFE orderDetails) {
        int orderId = sequencyGenerator.generateNextOrderId();
        UserDto userDto = fetchUserDetails(orderDetails.getUserId());
        Order orderTobeSaved = new Order(orderId, orderDetails.getFoodItems(), orderDetails.getRestaurant(), userDto);
        orderRepo.save(orderTobeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderTobeSaved);
    }


    private UserDto fetchUserDetails(int userId) {
        // fetch user details from user service
        return restTemplate.getForObject("http://USER-SERVICE/user/findUserById/" + userId, UserDto.class);
    }
}
