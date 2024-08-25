package com.example.order_service.service;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOderByOrderId(String orderId);
    Iterable<OrderEntity>getOrdersByUserId(String userId);

}
