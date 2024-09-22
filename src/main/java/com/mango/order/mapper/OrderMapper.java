package com.mango.order.mapper;

import com.mango.order.dto.OrderDTO;
import com.mango.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDtoToOrder(OrderDTO orderDto);
    OrderDTO mapOrderToOrderDto(Order order);
}
