package com.driver.ui.controller.Converter;

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

}
