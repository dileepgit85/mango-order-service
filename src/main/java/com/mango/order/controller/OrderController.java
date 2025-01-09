package com.mango.order.controller;

import com.mango.order.dto.OrderDTO;
import com.mango.order.dto.OrderDtoFromFE;
import com.mango.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDtoFromFE orderDetails) {
        OrderDTO order = orderService.createOrderInDb(orderDetails);
        return new ResponseEntity<OrderDTO>(order, HttpStatus.CREATED);
    }
}
