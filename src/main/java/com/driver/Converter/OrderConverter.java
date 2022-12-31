package com.driver.Converter;

import com.driver.io.entity.OrderEntity;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.shared.dto.OrderDto;

public class OrderConverter {

        public static OrderDetailsResponse dtoToResponse(OrderDto orderDto)
        {
            OrderDetailsResponse orderDetailsResponse = OrderDetailsResponse.builder()
                    .orderId(orderDto.getOrderId())
                    .cost(orderDto.getCost())
                    .items(orderDto.getItems())
                    .status(orderDto.isStatus())
                    .userId(orderDto.getUserId())
                    .build();
            return orderDetailsResponse;
        }
        public static OrderDto entityToDto(OrderEntity orderEntity)
        {
            OrderDto orderDto = OrderDto.builder()
                    .status(orderEntity.isStatus())
                    .id(orderEntity.getId())
                    .userId(orderEntity.getUserId())
                    .orderId(orderEntity.getOrderId())
                    .items(orderEntity.getItems())
                    .cost(orderEntity.getCost())
                    .build();
            return orderDto;
        }

}
