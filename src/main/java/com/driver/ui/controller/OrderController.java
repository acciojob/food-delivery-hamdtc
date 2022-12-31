package com.driver.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.driver.ui.controller.Converter.OrderConverter;
import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.model.response.RequestOperationName;
import com.driver.model.response.RequestOperationStatus;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping(path="/{id}")
	public OrderDetailsResponse getOrder(@PathVariable String id) throws Exception{
		OrderDto orderDto = orderService.getOrderById(id);
		OrderDetailsResponse orderDetailsResponse = OrderConverter.dtoToResponse(orderDto);
		return orderDetailsResponse;
	}
	
	@PostMapping()
	public OrderDetailsResponse createOrder(@RequestBody OrderDetailsRequestModel order) {
		OrderDto orderDto = OrderDto.builder().items(order.getItems()).cost(order.getCost()).userId(order.getUserId()).build();
		orderDto = orderService.createOrder(orderDto);
		OrderDetailsResponse orderDetailsResponse =OrderConverter.dtoToResponse(orderDto);

		return orderDetailsResponse;
	}

		
	@PutMapping(path="/{id}")
	public OrderDetailsResponse updateOrder(@PathVariable String id, @RequestBody OrderDetailsRequestModel order) throws Exception{
		OrderDto orderDto = OrderDto.builder().items(order.getItems()).cost(order.getCost()).userId(order.getUserId()).build();
		orderDto = orderService.updateOrderDetails(id, orderDto);
		OrderDetailsResponse orderDetailsResponse = OrderConverter.dtoToResponse(orderDto);
		return orderDetailsResponse;
	}
	
	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteOrder(@PathVariable String id) throws Exception {
		OperationStatusModel operationStatusModel = OperationStatusModel.builder()
				.operationName(RequestOperationName.DELETE.toString())
				.operationResult(RequestOperationStatus.SUCCESS.toString())
				.build();
		return operationStatusModel;
	}
	
	@GetMapping()
	public List<OrderDetailsResponse> getOrders() {
		List<OrderDto> list = orderService.getOrders();
		List<OrderDetailsResponse> responseList = new ArrayList<>();
		for(OrderDto orderDto : list)
		{
			OrderDetailsResponse orderDetailsResponse = OrderConverter.dtoToResponse(orderDto);
			responseList.add(orderDetailsResponse);
		}
		return responseList;
	}
}
