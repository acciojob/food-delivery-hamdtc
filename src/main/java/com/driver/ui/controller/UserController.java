package com.driver.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.driver.ui.controller.Converter.UserConverter;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.UserResponse;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;
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
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}")
	public UserResponse getUser(@PathVariable String id) throws Exception{
		UserDto userDto = userService.getUserByUserId(id);
		UserResponse userResponse = UserConverter.dtoToResponse(userDto);
		return userResponse;
	}
	@PostMapping()
	public UserResponse createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception{
		UserDto userDto = UserDto.builder().
				firstName(userDetails.getFirstName()).
				lastName(userDetails.getLastName()).
				email(userDetails.getEmail()).
				build();

		UserDto userDto1= userService.createUser(userDto);
		UserResponse userResponse = UserConverter.dtoToResponse(userDto1);
		return userResponse;
	}

	@PutMapping(path = "/{id}")
	public UserResponse updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) throws Exception{
		UserDto userDto = UserDto.builder().
				firstName(userDetails.getFirstName()).
				lastName(userDetails.getLastName()).
				email(userDetails.getEmail()).
				build();
		UserDto userDto1 = userService.updateUser(id,userDto);
		UserResponse userResponse = UserConverter.dtoToResponse(userDto1);
		return userResponse;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id) throws Exception{
		userService.deleteUser(id);
		return new OperationStatusModel();
	}
	
	@GetMapping()
	public List<UserResponse> getUsers(){

		List<UserDto> list = userService.getUsers();
		List<UserResponse> responseList = new ArrayList<>();
		for(UserDto userDto : list)
		{
			UserResponse userResponse = UserConverter.dtoToResponse(userDto);
				responseList.add(userResponse);
		}
		return responseList;
	}
	
}
